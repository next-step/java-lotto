package lotto;

import lotto.domain.WinningNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class WinningNumbersTest {
    @Test
    void 당첨번호_입력() {

        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        Assertions.assertThat(winningNumbers.getWinningNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    void 당첨번호_45초과_입력_오류() {
        Assertions.assertThatIllegalArgumentException().isThrownBy(
                () -> new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 46), 7)
        );
    }

    @Test
    void 당첨번호_1미만_입력_오류() {
        Assertions.assertThatIllegalArgumentException().isThrownBy(
                () -> new WinningNumbers(Arrays.asList(0, 2, 3, 4, 5, 45), 7)
        );
    }

    @Test
    void 보너스볼_46입력_오류() {
        Assertions.assertThatIllegalArgumentException().isThrownBy(
                () -> new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), 46)
        );
    }

    @Test
    void 보너스볼_0입력_오류() {
        Assertions.assertThatIllegalArgumentException().isThrownBy(
                () -> new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), 0)
        );
    }
}
