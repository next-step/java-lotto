package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step2.util.Constants;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class WinningLotteryTest {

    private WinningLottery winningLottery;

    @Test
    @DisplayName("입력된 당첨 번호가 6개가 아닌 경우 예외 발생 테스트")
    void winning_number_length_is_6() {
        String winningNumber = "1, 2, 3, 4, 5, 6, 7, 8";
        assertThatThrownBy(() -> winningLottery = new WinningLottery(winningNumber.split(Constants.COMMA_DELIMITER)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호는 6개여야만 합니다.");
    }
}