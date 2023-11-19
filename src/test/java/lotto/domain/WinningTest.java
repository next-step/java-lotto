package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class WinningTest {
    @DisplayName("당첨개수에 해당하는 당첨 금액을 리턴")
    @ParameterizedTest
    @CsvSource(value = {"6:0:2000000000", "5:1:30000000","5:0:1500000", "4:0:50000", "3:0:5000"}, delimiter = ':')
    void 당첨_금액(int correctCount, int bonusCorrectCount, int expectedWinningAmount) {
        int result = Winning.winningAmount(correctCount, bonusCorrectCount);

        assertThat(result).isEqualTo(expectedWinningAmount);
    }

    @DisplayName("enum에 유효하지 않은 값을 전달할경우")
    @Test
    void 유효하지않은_값() {
        int correctCount = 9;

        int result = Winning.winningAmount(correctCount, 0);

        assertThat(result).isEqualTo(0);
    }
}