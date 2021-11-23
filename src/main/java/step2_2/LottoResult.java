package step2_2;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResult {

    private static final int DEFAULT_REWARD = 0;

    private List<LottoReward> rewards;
    private Money money;

    public LottoResult(List<LottoReward> rewards, Money money) {
        this.rewards = rewards;
        this.money = money;
    }

    public double getYield() {
        int moneySum = getReward();
        return (double) moneySum / money.won();
    }

    private int getReward() {
        return rewards.stream()
            .map(LottoReward::getReward)
            .reduce(Integer::sum)
            .orElse(DEFAULT_REWARD);
    }

    public Map<LottoReward, Long> getRewardMap() {
        Map<LottoReward, Long> rewardMap = rewards.stream()
            .filter(LottoReward::isWin)
            .collect(Collectors.groupingBy(identity(), counting()));

        return Collections.unmodifiableMap(rewardMap);
    }
}
