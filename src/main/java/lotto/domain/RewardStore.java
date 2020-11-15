package lotto.domain;

import lotto.dto.RewardCountAndPrizeMoney;
import lotto.dto.WinLotteryResult;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RewardStore {
    private final List<RewardCount> rewardCounts = Arrays.stream(Reward.values()).map(RewardCount::of).collect(Collectors.toList());

    public int increaseHitCount(final int hitCount) {
        final Reward reward = Reward.find(hitCount);
        final RewardCount selectedRewardCount = rewardCounts.stream()
                .filter(rewardCount -> rewardCount.isMatch(reward))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
        selectedRewardCount.increase();
        return selectedRewardCount.getCount();
    }

    public int getCount(final Reward reward) {
        if (reward == null) {
            return 0;
        }
        
        return rewardCounts.stream()
                .filter(rewardCount -> rewardCount.isMatch(reward))
                .findAny()
                .map(RewardCount::getCount)
                .orElseThrow(IllegalArgumentException::new);
    }

    public WinLotteryResult toWinLotteryResult() {
        return new WinLotteryResult(
                createRewardCountAndPrizeMoney(Reward.HIT_THREE_TIMES),
                createRewardCountAndPrizeMoney(Reward.HIT_FOUR_TIMES),
                createRewardCountAndPrizeMoney(Reward.HIT_FIVE_TIMES),
                createRewardCountAndPrizeMoney(Reward.HIT_SIX_TIMES),
                calculateTotalPrizeMoney()
        );
    }

    private RewardCountAndPrizeMoney createRewardCountAndPrizeMoney(final Reward reward) {
        return new RewardCountAndPrizeMoney(reward.getHitTimes(), getCount(reward), reward.getMoney());
    }

    private Money calculateTotalPrizeMoney() {
        return Arrays.stream(Reward.values())
                .map(reward -> {
                    final Money money = reward.getMoney();
                    final int count = this.getCount(reward);
                    return money.multiply(count);
                })
                .reduce(Money::plus)
                .orElse(Money.EMPTY);
    }
}
