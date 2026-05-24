package efub.toyproject.tweeter.user.dto;

import efub.toyproject.tweeter.user.domain.User;

import java.time.LocalDateTime;

public record UserResponse (
    Long userId,
    String name,
    String handle,
    String bio,
    String profileImageUrl,
    LocalDateTime createdAt
) {
    public static UserResponse from(User user) {
        return new UserResponse(
                user.getUserId(),
                user.getName(),
                user.getHandle(),
                user.getBio(),
                user.getProfileImageUrl(),
                user.getCreatedAt()
        );
    }
}
