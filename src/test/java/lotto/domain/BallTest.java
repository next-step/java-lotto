package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BallTest {

    @Test
    @DisplayName("숫자 정상 생성 입력 테스트")
    void ball_inputValidateNumber() {
        /* given & when & then */
        assertDoesNotThrow(() -> new Ball("10"));
    }

}
