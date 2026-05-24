package efub.toyproject.tweeter.tweet.controller;

import efub.toyproject.tweeter.tweet.dto.request.CreateTweetRequest;
import efub.toyproject.tweeter.tweet.dto.response.CreateTweetResponse;
import efub.toyproject.tweeter.tweet.dto.response.GetTweetResponse;
import efub.toyproject.tweeter.tweet.service.TweetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tweets")
public class TweetController {
    private final TweetService tweetService;

    // 트윗 작성
    @PostMapping
    public ResponseEntity<CreateTweetResponse> createTweet(
            @RequestBody @Valid CreateTweetRequest request) {
        CreateTweetResponse response = tweetService.createTweet(request);
        return ResponseEntity
                .created(URI.create("/tweets/" + response.tweetId()))
                .body(response);
    }

    // 트윗 개별 조회
    @GetMapping("/{tweetId}")
    public ResponseEntity<GetTweetResponse> getTweet(@PathVariable("tweetId") Long tweetId) {
        return ResponseEntity.ok(tweetService.getTweet(tweetId));
    }

    // 트윗 전체 조회
    @GetMapping
    public ResponseEntity<List<GetTweetResponse>> getAllTweets() {
        List<GetTweetResponse> response = tweetService.getAllTweets();
        return ResponseEntity.ok(response);
    }

    // 트윗 삭제
    @DeleteMapping("/{tweetId}")
    public ResponseEntity<Void> deleteTweet(@PathVariable("tweetId") Long tweetId) {
        tweetService.deleteTweet(tweetId);
        return ResponseEntity.noContent().build();
    }
}
