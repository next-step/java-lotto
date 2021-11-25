package step3.model;

import java.util.Map;

public class LottoPrize {

    private final Map<LottoReward, Long> rewardCountMap;
    private final Money money;

    public LottoPrize(Map<LottoReward, Long> rewardCountMap, Money money) {
        this.rewardCountMap = rewardCountMap;
        this.money = money;
    }
}
