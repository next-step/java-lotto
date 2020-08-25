package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class ProfitTest {

    private Profit profit;
    private WinningResult winningResult;

    @BeforeEach
    void setUp() {
        winningResult = new WinningResult();
        profit = new Profit(winningResult);
        winningResult.putRank(Rank.FOURTH);
        winningResult.putRank(Rank.FOURTH);
        winningResult.putRank(Rank.THIRD);
    }

    @Test
    @DisplayName("당첨 금액 확인")
    void checkTheWinningAmount() {
        int result = profit.getWinningAmount();
        assertThat(result).isEqualTo(1_600_000);
    }

    @ParameterizedTest
    @DisplayName("수익률 확인")
    @CsvSource(value = {"14000:5000:0.35", "20000:5000:0.25", "1000:50000:50.00"}, delimiter = ':')
    void rateOfReturn(int price, int winningAmount, String expected) {
        String result = profit.getRateOfReturn(price, winningAmount);
        assertThat(result).isEqualTo(expected);
    }
}
