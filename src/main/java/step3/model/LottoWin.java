package step3.model;

import java.util.Map;

public class LottoWin {

    private static final int DEFAULT_REWARD = 0;

    private final Map<Reward, Long> rewardMap;

    public LottoWin(Map<Reward, Long> rewardMap) {
        this.rewardMap = rewardMap;
    }

    public Money totalReward() {
        Money total = new Money(DEFAULT_REWARD);
        for (Reward reward : rewardMap.keySet()) {
            Money rewardMoney = reward.getRewardMoney();
            Long winCount = rewardMap.get(reward);
            total.add(rewardMoney.won() * winCount);
        }
        return total;
    }
}
