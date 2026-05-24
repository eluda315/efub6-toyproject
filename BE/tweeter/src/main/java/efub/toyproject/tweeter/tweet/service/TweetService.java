package efub.toyproject.tweeter.tweet.service;

import efub.toyproject.tweeter.global.exception.CustomException;
import efub.toyproject.tweeter.global.exception.ErrorCode;
import efub.toyproject.tweeter.tweet.domain.Tweet;
import efub.toyproject.tweeter.tweet.dto.request.CreateTweetRequest;
import efub.toyproject.tweeter.tweet.dto.response.CreateTweetResponse;
import efub.toyproject.tweeter.tweet.dto.response.GetTweetResponse;
import efub.toyproject.tweeter.tweet.repository.TweetRepository;
import efub.toyproject.tweeter.user.domain.User;
import efub.toyproject.tweeter.user.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TweetService {
    private final TweetRepository tweetRepository;
    private final UserRepository userRepository;

    // 트윗 작성
    @Transactional
    public CreateTweetResponse createTweet(CreateTweetRequest request) {
        User writer = findByUserId(request.getUserId());

        Tweet newTweet = request.toEntity(writer);
        Tweet savedTweet = tweetRepository.save(newTweet);

        return CreateTweetResponse.from(savedTweet);
    }

    @Transactional(readOnly = true)
    public GetTweetResponse getTweet(Long tweetId) {
        Tweet tweet = findByTweetId(tweetId);
        return GetTweetResponse.from(tweet);
    }

    @Transactional(readOnly = true)
    public List<GetTweetResponse> getAllTweets() {
        List<Tweet> tweets = tweetRepository.findAll();

        return tweets.stream()
                .map(GetTweetResponse::from)
                .collect(Collectors.toList());
    }

    @Transactional
    public void deleteTweet(Long tweetId) {
        Tweet tweet = findByTweetId(tweetId);
        tweetRepository.delete(tweet);
    }

    private User findByUserId(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));
    }

    private Tweet findByTweetId(Long tweetId) {
        return tweetRepository.findById(tweetId)
                .orElseThrow(() -> new CustomException(ErrorCode.TWEET_NOT_FOUND));
    }



}
