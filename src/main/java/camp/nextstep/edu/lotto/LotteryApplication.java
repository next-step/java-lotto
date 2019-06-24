package camp.nextstep.edu.lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryApplication {

    private static final NaturalNumber PRICE_OF_LOTTERY = NaturalNumber.from(1000);
    private static final int ZERO = 0;

    public NaturalNumber calculateNumberOfAvailableLotteries(NaturalNumber investment) {
        if (investment == null) {
            throw new IllegalArgumentException("'investment' must not be null");
        }
        return investment.divideBy(PRICE_OF_LOTTERY);
    }

    public List<Lottery> purchase(NaturalNumber numberOfLotteries) {
        final int value = numberOfLotteries.value();
        return IntStream.range(ZERO, value)
                .mapToObj(number -> Lottery.randomizedInstance())
                .collect(Collectors.toList());
    }

    public int countScore(Lottery lottery, Lottery winningLottery) {
        if (lottery == null) {
            throw new IllegalArgumentException("'lottery' must not be null");
        }
        if (winningLottery == null) {
            throw new IllegalArgumentException("'winningLottery' must not be null");
        }
        return lottery.score(winningLottery);
    }

    public long getReward(int score) {
        if (score < 0) {
            throw new IllegalArgumentException("'score' must be greater than or equal to 0");
        }
        if (score == 3) {
            return 5000;
        }
        if (score == 4) {
            return 50000;
        }
        if (score == 5) {
            return 1500000;
        }
        if (score == 6) {
            return 2000000000;
        }
        return 0;
    }
}
