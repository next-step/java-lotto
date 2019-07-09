package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class InputTest {

    @DisplayName("구매금액 입력 확인: empty 불가")
    @Test
    public void 구매금액_입력() {

        assertThatIllegalArgumentException().isThrownBy(() -> InputValidationCheck.checkEmpty(""));
    }

    @DisplayName("구매금액 입력 확인: 1000원 미만 불가")
    @Test
    public void 구매액수_확인() {

        assertThatIllegalArgumentException().isThrownBy(() -> InputValidationCheck.checkCash("900"));
    }

    @DisplayName("당첨번호 입력받기 확인: 6자리 입력")
    @Test
    public void 입력받은_당첨번호_자릿수_확인() {
        String[] winningNumbers = "30, 2, 12, 22, 45, 100".split(",");
        assertThat(winningNumbers.length).isEqualTo(Lotto.WINNING_NUMBERS_LENGTH);
    }

    @DisplayName("당첨번호 범위 확인: 1 ~ 45")
    @Test
    public void 당첨번호_범위_확인() {
        String[] winningNumbers = "30, 2, 12, 22, 45, 100".split(",");
        assertThatIllegalArgumentException().isThrownBy(() -> InputValidationCheck.checkWinningNumberRange(winningNumbers));
    }

    @DisplayName("당첨번호 중복 확인")
    @Test
    public void 당첨번호_중복_확인() {
        String[] winningNumbers = "30, 2, 12, 22, 45, 45".split(",");
        assertThatIllegalArgumentException().isThrownBy(() -> InputValidationCheck.checkOverlapWinningNumber(winningNumbers));
    }
}
