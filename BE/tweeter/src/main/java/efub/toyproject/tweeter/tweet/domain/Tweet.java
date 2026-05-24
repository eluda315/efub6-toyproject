package efub.toyproject.tweeter.tweet.domain;

import efub.toyproject.tweeter.global.domain.BaseEntity;
import efub.toyproject.tweeter.user.domain.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Tweet extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tweetId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User writer;

    @Column(nullable = false)
    private String content;

    @Column(nullable = true)
    private String tweetImageUrl;

    @Builder
    public Tweet(User writer, String content, String tweetImageUrl) {
        this.writer=writer;
        this.content=content;
        this.tweetImageUrl=tweetImageUrl;
    }
}
