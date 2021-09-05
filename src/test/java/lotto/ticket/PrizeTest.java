package lotto.ticket;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("티켓의 당첨금은")
class PrizeTest {

    @DisplayName("보너스 숫자가 0개이고, 티켓의 숫자가 당첨 숫자와")
    @ParameterizedTest(name = "{0}개 일치: {1}원")
    @CsvSource(value = {"6,2000000000", "5,1500000", "4,50000", "3,5000", "2,0", "1,0", "0,0"})
    void prizeForZeroBonusAndSomeWinningNumbers(int winningNumberCounts, int prizeMoney) {
        assertThat(Prize.prize(winningNumberCounts, 0).prizeMoney()).isEqualTo(prizeMoney);
    }

    @DisplayName("티켓의 숫자가 당첨숫자와 5개 일치하고")
    @ParameterizedTest(name = "보너스 숫자가 {0}개 일치: {1}원")
    @CsvSource(value = {"1,30000000", "0,1500000"})
    void prizeForBonusNumber(int bonusNumber, int prizeMoney) {
        assertThat(Prize.prize(5, bonusNumber).prizeMoney()).isEqualTo(prizeMoney);
    }

}
