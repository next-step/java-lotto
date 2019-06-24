package camp.nextstep.edu.lotto.controller;

import camp.nextstep.edu.lotto.domain.Lottery;
import camp.nextstep.edu.lotto.domain.NaturalNumber;
import camp.nextstep.edu.lotto.domain.RewardType;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryController {

    private static final NaturalNumber PRICE_OF_LOTTERY = NaturalNumber.from(1000);
    private static final int ZERO = 0;

    public List<Lottery> purchase(int investment) {
        final NaturalNumber naturalNumberInvestment = NaturalNumber.from(investment);
        final NaturalNumber naturalNumberOfLotteries = this.calculateNumberOfAvailableLotteries(naturalNumberInvestment);
        final int numberOfLotteries = naturalNumberOfLotteries.value();
        return IntStream.range(ZERO, numberOfLotteries)
                .mapToObj(number -> Lottery.randomizedInstance())
                .collect(Collectors.toList());
    }

    public Map<RewardType, Integer> getResult(List<Lottery> purchasedLotteries, Set<Integer> winningNumberSet) {
        final Lottery winningLottery = Lottery.customizedInstance(winningNumberSet);

        final EnumMap<RewardType, Integer> rewardMap = new EnumMap<>(RewardType.class);
        rewardMap.put(RewardType.SIX_NUMBERS_MATCHED, 0);
        rewardMap.put(RewardType.FIVE_NUMBERS_MATCHED, 0);
        rewardMap.put(RewardType.FOUR_NUMBERS_MATCHED, 0);
        rewardMap.put(RewardType.THREE_NUMBERS_MATCHED, 0);

        purchasedLotteries.stream()
                .map(lottery -> this.countScore(lottery, winningLottery))
                .forEach(score -> {
                    final RewardType rewardType = RewardType.from(score);
                    final int current = rewardMap.getOrDefault(rewardType, 0);
                    rewardMap.put(rewardType, current + 1);
                });

        return rewardMap;
    }

    public double calculateEarningsRate(int investment, long reward) {
        if (investment <= ZERO) {
            throw new IllegalArgumentException("'investment' must be greater than " + ZERO);
        }
        if (reward < ZERO) {
            throw new IllegalArgumentException("'reward' must be greater than or equal to " + ZERO);
        }
        return reward / (double) investment;
    }

    public long sumAllRewards(Map<RewardType, Integer> rewardMap) {
        return rewardMap.entrySet()
                .stream()
                .map(entry -> entry.getKey().getReward() * entry.getValue())
                .reduce(0L, Long::sum);
    }

    private NaturalNumber calculateNumberOfAvailableLotteries(NaturalNumber investment) {
        if (investment == null) {
            throw new IllegalArgumentException("'investment' must not be null");
        }
        return investment.divideBy(PRICE_OF_LOTTERY);
    }

    private int countScore(Lottery lottery, Lottery winningLottery) {
        if (lottery == null) {
            throw new IllegalArgumentException("'lottery' must not be null");
        }
        if (winningLottery == null) {
            throw new IllegalArgumentException("'winningLottery' must not be null");
        }
        return lottery.score(winningLottery);
    }
}
