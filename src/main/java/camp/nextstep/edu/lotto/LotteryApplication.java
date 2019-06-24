package camp.nextstep.edu.lotto;

import java.util.Arrays;
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
        final RewardType rewardType = RewardType.from(score);
        return rewardType.reward;
    }

    public double calculateEarningsRate(int investment, long reward) {
        if (investment == 0) {
            throw new IllegalArgumentException("'investment' must be greater than 0");
        }
        if (reward < 0) {
            throw new IllegalArgumentException("'reward' must be greater than or equal to 0");
        }
        return reward / (double) investment;
    }

    public enum RewardType {
        SIX_NUMBERS_MATCHED(6, 2000000000),
        FIVE_NUMBERS_MATCHED(5, 1500000),
        FOUR_NUMBERS_MATCHED(4, 50000),
        THREE_NUMBERS_MATCHED(3, 5000),
        UNKNOWN(0, 0);

        public static final int MINIMUM_SCORE = 0;

        private final int score;
        private final long reward;

        RewardType(int score, int reward) {
            this.score = score;
            this.reward = reward;
        }

        public static RewardType from(int score) {
            if (score < MINIMUM_SCORE) {
                throw new IllegalArgumentException("'score' must be greater than or equal to 0");
            }
            return Arrays.stream(RewardType.values())
                    .filter(value -> value.score == score)
                    .findFirst()
                    .orElse(UNKNOWN);
        }
    }
}
