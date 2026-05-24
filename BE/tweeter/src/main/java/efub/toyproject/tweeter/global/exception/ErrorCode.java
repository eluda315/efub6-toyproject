package efub.toyproject.tweeter.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    // Default
    INTERNAL_SERVER_ERROR(500, "서버 내부에서 알 수 없는 오류가 발생했습니다. 잠시 후 다시 시도해주세요."),
    ERROR(400, "잘못된 요청입니다."),

    // user
    USER_NOT_FOUND(404, "존재하지 않는 사용자입니다."),

    // tweet
    TWEET_NOT_FOUND(404, "해당 id의 트윗이 존재하지 않습니다."),
    TWEET_USER_MISMATCH(401, "트윗 생성자가 아닙니다.");


    private final int status;
    private final String message;
}
