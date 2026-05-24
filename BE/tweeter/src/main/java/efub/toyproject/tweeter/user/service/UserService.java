package efub.toyproject.tweeter.user.service;

import efub.toyproject.tweeter.global.exception.CustomException;
import efub.toyproject.tweeter.global.exception.ErrorCode;
import efub.toyproject.tweeter.user.domain.User;
import efub.toyproject.tweeter.user.dto.UserResponse;
import efub.toyproject.tweeter.user.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    // 사용자 단건 조회
    @Transactional(readOnly = true)
    public UserResponse getUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));

        return UserResponse.from(user);
    }
}
