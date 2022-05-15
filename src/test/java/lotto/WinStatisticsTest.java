package lotto;

import lotto.controller.WinStatistics;
import lotto.model.Money;
import lotto.model.Reward;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinStatisticsTest {
    @Test
    void shouldSave3toThree() {
        WinStatistics winStatistics = new WinStatistics();
        winStatistics.save(Reward.of(3, false));
        assertThat(winStatistics).isEqualTo(new WinStatistics(1, 0, 0, 0, 0));
    }

    @Test
    void toPayloadShouldFormatWins() {
        WinStatistics winStatistics = new WinStatistics(1, 0, 0, 0, 0);
        assertThat(winStatistics.toPayload()).isEqualTo(
                "THREE matches (₩5000): 1\n" +
                "FOUR matches (₩50000): 0\n" +
                "FIVE matches (₩1500000): 0\n" +
                "BONUS matches (₩30000000): 0\n" +
                "SIX matches (₩2000000000): 0\n");
    }

    @Test
    void earnedMoneyShouldBe55000() {
        WinStatistics winStatistics = new WinStatistics(1, 1, 0, 0, 0);
        assertThat(winStatistics.getEarnedMoney()).isEqualTo(55000);
    }

    @Test
    void earningRateShouldBeFiveTenth() {
        WinStatistics winStatistics = new WinStatistics(1, 0, 0, 0, 0);
        assertThat(winStatistics.getEarningRate(new Money(10000))).isEqualTo(0.5);
    }
}
