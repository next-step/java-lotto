package lottery;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LotteryCalculatorTest {
    @Test
    public void getNumberOfMatchingNumbersTest() {
        var lottery = Lottery.fromGiven(Set.of(1, 2, 3, 4, 5, 6));
        var numbers = Set.of(1, 4, 6, 10, 45, 49);

        var lotteryCalculator = new LotteryCalculator();
        var result = lotteryCalculator.getNumMatches(lottery, numbers);

        assertThat(result).isEqualTo(3);
    }

    @Test
    public void getNumberOfLotteriesForNumberOfMatchingNumbersTest() {
        var lotteries = List.of(
                Lottery.fromGiven(Set.of(1, 2, 3, 4, 5, 6)),
                Lottery.fromGiven(Set.of(1, 2, 3, 10, 11, 12)),
                Lottery.fromGiven(Set.of(1, 2, 3, 4, 10, 11)),
                Lottery.fromGiven(Set.of(1, 2, 3, 4, 5, 10))
        );
        var numbers = Set.of(1, 2, 3, 4, 5, 6);

        var lotteryCalculator = new LotteryCalculator();
        var result = lotteryCalculator.getLotteryCountForNumMatches(lotteries, numbers);

        assertThat(result).containsExactly(0, 0, 0, 1, 1, 1, 1);
    }

    @Test
    public void getPnLResultTest() {
        var totalSpending = 14000;
        var lotteryCountForNumMatches = List.of(0, 0, 0, 1, 0, 0, 0);

        var lotteryCalculator = new LotteryCalculator();
        var result = lotteryCalculator.getPnLResultFromLotteryCountForNumMatches(lotteryCountForNumMatches, totalSpending);

        assertThat(result.ror).isCloseTo(0.35714f, Percentage.withPercentage(1d));
        assertThat(result.pnLType).isEqualTo(PnLType.LOSS);
    }
}
