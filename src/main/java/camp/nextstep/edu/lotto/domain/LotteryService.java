package camp.nextstep.edu.lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryService {

    private static final NaturalNumber PRICE_OF_LOTTERY = NaturalNumber.from(1000);
    private static final int ZERO = 0;
    private static final int COUNT_UNIT = 1;
    private static final int COUNT_DEFAULT = 0;
    private static final long IDENTITY_LONG = 0L;

    public List<Lottery> purchase(int investment) {
        final NaturalNumber naturalNumberInvestment = NaturalNumber.from(investment);
        final NaturalNumber naturalNumberOfLotteries = naturalNumberInvestment.divideBy(PRICE_OF_LOTTERY);
        final int numberOfLotteries = naturalNumberOfLotteries.value();
        return IntStream.range(ZERO, numberOfLotteries)
                .mapToObj(number -> Lottery.randomizedInstance())
                .collect(Collectors.toList());
    }

    public Map<RewardType, Integer> getResult(List<Lottery> purchasedLotteries, Set<Integer> winningNumberSet) {
        final Lottery winningLottery = Lottery.customizedInstance(winningNumberSet);
        return this.resolveRewards(purchasedLotteries, winningLottery);
    }

    private Map<RewardType, Integer> resolveRewards(List<Lottery> purchasedLotteries, Lottery winningLottery) {
        final EnumMap<RewardType, Integer> rewardMap = new EnumMap<>(RewardType.class);
        rewardMap.put(RewardType.SIX_NUMBERS_MATCHED, COUNT_DEFAULT);
        rewardMap.put(RewardType.FIVE_NUMBERS_MATCHED, COUNT_DEFAULT);
        rewardMap.put(RewardType.FOUR_NUMBERS_MATCHED, COUNT_DEFAULT);
        rewardMap.put(RewardType.THREE_NUMBERS_MATCHED, COUNT_DEFAULT);

        purchasedLotteries.stream()
                .map(lottery -> lottery.score(winningLottery))
                .forEach(score -> {
                    final RewardType rewardType = RewardType.from(score);
                    final int current = rewardMap.getOrDefault(rewardType, COUNT_DEFAULT);
                    rewardMap.put(rewardType, current + COUNT_UNIT);
                });

        return rewardMap;
    }

    public double calculateEarningsRate(int investment, Map<RewardType, Integer> rewardMap) {
        final double reward = this.sumAllRewards(rewardMap);
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

    private long sumAllRewards(Map<RewardType, Integer> rewardMap) {
        return rewardMap.entrySet()
                .stream()
                .map(entry -> entry.getKey().getReward() * entry.getValue())
                .reduce(IDENTITY_LONG, Long::sum);
    }
}
