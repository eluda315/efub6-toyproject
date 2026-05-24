package efub.toyproject.tweeter.user.domain;

import efub.toyproject.tweeter.global.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true, length = 15)
    private String handle;

    @Column(nullable = true)
    private String bio;

    @Column(nullable = true)
    private String profileImageUrl;

    @Builder
    public User(String name, String handle, String bio, String profileImageUrl) {
        this.name = name;
        this.handle = handle;
        this.bio = bio;
        this.profileImageUrl = profileImageUrl;
    }
}
