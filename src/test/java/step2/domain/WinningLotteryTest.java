package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.exception.NumberMustBeSixException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static step2.domain.WinningLottery.WINNING_NUMBER_MUST_BE_6;

class WinningLotteryTest {

    private WinningLottery winningLottery;

    @Test
    @DisplayName("입력된 당첨 번호가 6개가 아닌 경우 예외 발생 테스트")
    void winning_number_length_is_6() {
        String winningNumber = "1, 2, 3, 4, 5, 6, 7, 8";
        assertThatThrownBy(() -> winningLottery = new WinningLottery(winningNumber))
                .isInstanceOf(NumberMustBeSixException.class)
                .hasMessageContaining(WINNING_NUMBER_MUST_BE_6);
    }
}