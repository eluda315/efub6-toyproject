package efub.toyproject.tweeter.tweet.dto.response;

import efub.toyproject.tweeter.tweet.domain.Tweet;

import java.time.LocalDateTime;

public record GetTweetResponse (
        Long tweetId,
        Long userId,
        String name,
        String handle,
        String profileImageUrl,
        String content,
        String tweetImageUrl,
        LocalDateTime createdAt
) {
    // 💡 매개변수를 Tweet 하나로 줄이고 이름도 from으로 변경!
    public static GetTweetResponse from(Tweet tweet) {
        return new GetTweetResponse(
                tweet.getTweetId(),
                tweet.getWriter().getUserId(),
                tweet.getWriter().getName(),
                tweet.getWriter().getHandle(),
                tweet.getWriter().getProfileImageUrl(),
                tweet.getContent(),
                tweet.getTweetImageUrl(),
                tweet.getCreatedAt()
        );
    }
}