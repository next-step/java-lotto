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
                new Lottery(LotteryRow.fromGiven(Set.of(1, 2, 3, 4, 5, 7))),
                new Lottery(LotteryRow.fromGiven(Set.of(1, 2, 3, 4, 5, 30))),
                new Lottery(LotteryRow.fromGiven(Set.of(1, 2, 3, 4, 30, 31))),
                new Lottery(LotteryRow.fromGiven(Set.of(1, 2, 3, 30, 31, 32))),
                new Lottery(LotteryRow.fromGiven(Set.of(31, 32, 33, 34, 35, 36)))
        );
        var drawResult = new DrawResult(LotteryRow.fromGiven(Set.of(1, 2, 3, 4, 5, 6)), LotteryNumber.fromGiven(7));

        var lotteryStatistics = new LotteryStatistics(lotteries, drawResult);

        assertThat(lotteryStatistics.getLotteryCntForPlace(LotteryPlace.FIRST).value()).isEqualTo(1);
        assertThat(lotteryStatistics.getLotteryCntForPlace(LotteryPlace.SECOND).value()).isEqualTo(1);
        assertThat(lotteryStatistics.getLotteryCntForPlace(LotteryPlace.THIRD).value()).isEqualTo(1);
        assertThat(lotteryStatistics.getLotteryCntForPlace(LotteryPlace.FOURTH).value()).isEqualTo(1);
        assertThat(lotteryStatistics.getLotteryCntForPlace(LotteryPlace.FIFTH).value()).isEqualTo(1);
        assertThat(lotteryStatistics.getLotteryCntForPlace(LotteryPlace.MISS).value()).isEqualTo(1);
        assertThat(lotteryStatistics.getPnLType()).isEqualTo(PnLType.PROFIT);
        assertThat(lotteryStatistics.getRor()).isCloseTo(338592.5f, Percentage.withPercentage(1d));
    }
}
