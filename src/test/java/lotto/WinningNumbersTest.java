package lotto;

import lotto.model.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.common.LottoConstants.LOTTO_NUMBER_OUT_OF_BOUND_MESSAGE;
import static lotto.common.LottoConstants.WINNING_NUMBER_CREATE_FAIL_MESSAGE;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class WinningNumbersTest {
    @Test
    @DisplayName("범위를 벗어나는 당첨 번호")
    public void lottoNumberValid() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new WinningNumbers("1,2,3,4,5,55")
        ).withMessage(LOTTO_NUMBER_OUT_OF_BOUND_MESSAGE);
    }

    @Test
    @DisplayName("당첨 번호 6개가 아닐 경우")
    public void lottoNumberCountValid() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new WinningNumbers("1,2,3,4,5")
        ).withMessage(WINNING_NUMBER_CREATE_FAIL_MESSAGE);
    }

}
