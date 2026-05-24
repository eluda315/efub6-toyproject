package efub.toyproject.tweeter.tweet.dto.response;

import efub.toyproject.tweeter.tweet.domain.Tweet;
import java.time.LocalDateTime;

public record CreateTweetResponse (
        Long tweetId,
        Long userId,
        String content,
        String imageUrl,
        LocalDateTime createdAt
) {
    public static CreateTweetResponse from(Tweet tweet) {
        return new CreateTweetResponse(
                tweet.getTweetId(),
                tweet.getWriter().getUserId(),
                tweet.getContent(),
                tweet.getTweetImageUrl(),
                tweet.getCreatedAt()
        );
    }
}
