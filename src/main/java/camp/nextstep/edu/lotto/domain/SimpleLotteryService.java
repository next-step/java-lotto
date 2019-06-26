package camp.nextstep.edu.lotto.domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SimpleLotteryService implements LotteryService {

    private static final NaturalNumber PRICE_OF_LOTTERY = NaturalNumber.from(1000);
    private static final int ZERO = 0;

    @Override
    public Lotteries purchase(int investment) {
        final NaturalNumber naturalNumberInvestment = NaturalNumber.from(investment);
        final NaturalNumber naturalNumberOfLotteries = naturalNumberInvestment.divideBy(PRICE_OF_LOTTERY);
        final int numberOfLotteries = naturalNumberOfLotteries.value();
        final List<Lottery> lotteryList = IntStream.range(ZERO, numberOfLotteries)
                .mapToObj(number -> Lottery.randomizedInstance())
                .collect(Collectors.toList());
        return Lotteries.from(lotteryList);
    }

    @Override
    public LotteriesReward getResult(Lotteries purchasedLotteries, Set<Integer> winningNumberSet) {
        final Set<LotteryNumber> winningLotteryNumberSet = winningNumberSet.stream()
                .map(LotteryNumber::from)
                .collect(Collectors.toSet());
        final Lottery winningLottery = Lottery.customizedInstance(winningLotteryNumberSet);
        return this.resolveRewards(purchasedLotteries, winningLottery);
    }

    private LotteriesReward resolveRewards(Lotteries purchasedLotteries, Lottery winningLottery) {
        final LotteriesReward lotteriesReward = LotteriesReward.defaultInstance();

        purchasedLotteries.stream()
                .map(lottery -> lottery.score(winningLottery))
                .forEach(score -> {
                    final RewardType rewardType = RewardType.from(score);
                    lotteriesReward.add(rewardType);
                });

        return lotteriesReward;
    }

    @Override
    public double calculateEarningsRate(int investment, LotteriesReward lotteriesReward) {
        final double reward = lotteriesReward.sumAllRewards();
        return this.resolveEarningRate(investment, reward);
    }

    private double resolveEarningRate(int investment, double reward) {
        if (investment <= ZERO) {
            throw new IllegalArgumentException("'investment' must be greater than " + ZERO);
        }
        if (reward < ZERO) {
            throw new IllegalArgumentException("'reward' must be greater than or equal to " + ZERO);
        }
        return reward / (double) investment;
    }
}
