package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class WinningNumberTest {
    @Test
    @DisplayName("당첨번호 입력 시 중복된 숫자가 있으면 IllegalArgumentException 이 발생한다.")
    void 당첨번호_중복() {
        assertThatIllegalArgumentException().isThrownBy(() -> new WinningNumber("1, 2, 3, 4, 5, 5", "7"));
    }

    @Test
    @DisplayName("보너스 번호 입력 시 당첨번호와 중복된 숫자가 있으면 IllegalArgumentException 이 발생한다.")
    void 보너스번호_중복() {
        assertThatIllegalArgumentException().isThrownBy(() -> new WinningNumber("1, 2, 3, 4, 5, 6", "6"));
    }

    @Test
    @DisplayName("보너스 번호 입력 시 1~45 사이의 숫자가 아니면 IllegalArgumentException 이 발생한다.")
    void 보너스번호_범위() {
        assertThatIllegalArgumentException().isThrownBy(() -> new WinningNumber("1, 2, 3, 4, 5, 6", "46"));
    }
}