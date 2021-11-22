package step2_2;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResult {

    private List<LottoReward> rewards;
    private Money money;

    public LottoResult(List<LottoReward> rewards, Money money) {
        this.rewards = rewards;
        this.money = money;
    }

    public double getYield() {
        int yieldSum = getYieldSum();
        return (double) yieldSum / money.won();
    }

    private int getYieldSum() {
        return rewards.stream()
            .mapToInt(LottoReward::getReward)
            .sum();
    }

    public Map<Long, Long> getWinsCount() {
        return rewards.stream()
            .collect(Collectors.groupingBy(LottoReward::getMatchCount, Collectors.counting()));
    }
}
