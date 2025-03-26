package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class WinningNumberTest {
    @Test
    @DisplayName("당첨번호 입력 시 중복된 숫자가 있으면 IllegalArgumentException 이 발생한다.")
    void 당첨번호_중복() {
        assertThatIllegalArgumentException().isThrownBy(() -> new WinningNumber("1, 2, 3, 4, 5, 5"));
    }
}