package lottery;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LotteryStatisticsTest {
    @Test
    public void getsMatchingCountAndPnlResults() {
        var lotteries = List.of(
                new Lottery(LotteryRow.fromGiven(Set.of(1, 2, 3, 4, 5, 6))),
                new Lottery(LotteryRow.fromGiven(Set.of(1, 2, 3, 4, 5, 30))),
                new Lottery(LotteryRow.fromGiven(Set.of(1, 2, 3, 4, 30, 31))),
                new Lottery(LotteryRow.fromGiven(Set.of(31, 32, 33, 34, 35, 36)))
        );
        var winningRow = LotteryRow.fromGiven(Set.of(1, 2, 3, 4, 5, 6));
        var pricePerLottery = 1000;

        var lotteryStatistics = new LotteryStatistics(lotteries, winningRow, pricePerLottery);

        assertThat(lotteryStatistics.getLotteryCntForMatchCnt(6)).isEqualTo(1);
        assertThat(lotteryStatistics.getLotteryCntForMatchCnt(5)).isEqualTo(1);
        assertThat(lotteryStatistics.getLotteryCntForMatchCnt(4)).isEqualTo(1);
        assertThat(lotteryStatistics.getLotteryCntForMatchCnt(0)).isEqualTo(1);
        assertThat(lotteryStatistics.getPnLType()).isEqualTo(PnLType.PROFIT);
        assertThat(lotteryStatistics.getRor()).isCloseTo(500049.97f, Percentage.withPercentage(1d));
    }
}
