package step2_2;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;

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
        int moneySum = getMoneySum();
        return (double) moneySum / money.won();
    }

    private int getMoneySum() {
        return rewards.stream()
            .map(LottoReward::getReward)
            .mapToInt(Money::won)
            .sum();
    }

    public Map<LottoReward, Long> getRewardMap() {
        return rewards.stream()
            .filter(LottoReward::isWin)
            .collect(Collectors.groupingBy(identity(), counting()));
    }
}
