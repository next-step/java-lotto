package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step2.util.Constants;

import static org.assertj.core.api.Assertions.assertThat;
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
                .hasMessageContaining(Constants.WINNING_NUMBER_MUST_BE_6);
    }

    @Test
    @DisplayName("당첨 번호 range가 1이상 45이하의 범위를 벗어난는 경우 예외 발생 테스트")
    void is_valid_winning_number() {
        String winningNumber = "1, 2, 3, 4, 5, 47";
        assertThatThrownBy(() -> winningLottery = new WinningLottery(winningNumber.split(Constants.COMMA_DELIMITER)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constants.WINNING_NUMBER_INVALID_RANGE);
    }
}