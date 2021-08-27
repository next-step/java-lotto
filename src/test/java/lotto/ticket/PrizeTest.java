package lotto.ticket;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("티켓의 당첨금은")
public class PrizeTest {

    @DisplayName("티켓의 숫자가 당첨 숫자와")
    @ParameterizedTest(name = "{0}개 일치할 때: {1}원")
    @CsvSource(value = {"6:2000000000", "5:1500000", "4:50000", "3:5000", "0:0"}, delimiter = ':')
    void prizeIsDecidedByWinningNumberCounts(int winningNumberCounts, int prizeMoney) {
        assertThat(Prize.calculatePrizeMoney(winningNumberCounts).getPrizeMoney()).isEqualTo(prizeMoney);
    }

    @DisplayName("티켓 당첨 번호의 갯수가 1,2면 당첨금은 0원이다.")
    @ParameterizedTest(name = "당첨번호 갯수 {0}개")
    @ValueSource(ints = {1, 2})
    void prizeThrowsException(int winningNumbersCount) {
        assertThat(Prize.calculatePrizeMoney(winningNumbersCount).getPrizeMoney()).isEqualTo(0);
    }
}
