package efub.toyproject.tweeter.tweet.dto.request;

import efub.toyproject.tweeter.tweet.domain.Tweet;
import efub.toyproject.tweeter.user.domain.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreateTweetRequest {

    @NotNull(message = "작성자 ID는 필수입니다.")
    private Long userId;

    @NotBlank(message = "내용은 비울 수 없습니다.")
    private String content;

    private String imageUrl;

    public Tweet toEntity(User user) {
        return Tweet.builder()
                .writer(user)
                .content(content)
                .tweetImageUrl(imageUrl)
                .build();
    }
}
