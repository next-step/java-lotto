package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class LotteryResult {

    private final Map<Rank, Long> statistics;
    private final Money reward;

    public LotteryResult(Map<Rank, Long> statistics, Money reward) {
        this.statistics = statistics;
        this.reward = reward;
    }

    public Map<Rank, Long> getStatistics() {
        return statistics;
    }

    public BigDecimal ratio() {
        long total = statistics.values().stream().reduce(0L, Long::sum);
        Money paid = LottoTicket.PRICE.multiply(total);
        return reward.ratio(paid).setScale(2, RoundingMode.HALF_EVEN);
    }

    public static LotteryResult from(Map<Rank, Long> result) {
        Map<Rank, Long> values = Arrays.stream(Rank.values())
                .collect(Collectors.toMap(value -> value, value -> result.getOrDefault(value, 0L), (a, b) -> b));
        return new LotteryResult(values, calculate(values));
    }

    private static Money calculate(Map<Rank, Long> result) {
        Money amount = Money.from(0);
        for (Map.Entry<Rank, Long> entry : result.entrySet()) {
            amount = amount.add(entry.getKey().getReward().multiply(entry.getValue()));
        }
        return amount;
    }
}
