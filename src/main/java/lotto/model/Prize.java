package lotto.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import static lotto.model.Money.LOTTO_PER_MONEY;

public class Prize {
    private final Map<Rank, Integer> prizeMap;

    public Prize(List<Rank> ranks) {
        this(toEnumMap(ranks));
    }

    private static EnumMap<Rank, Integer> toEnumMap(List<Rank> ranks) {
        return ranks.stream()
                .collect(Collectors.toMap(Function.identity(), e -> 1, Integer::sum, () -> new EnumMap<>(Rank.class)));
    }

    public Prize(Map<Rank, Integer> prizeMap) {
        this.prizeMap = prizeMap;
    }

    public int rankCount(Rank rank) {
        return prizeMap.getOrDefault(rank, 0);
    }

    // 수익률 = 총 수익 / 총 비용
    public double rateOfReturn(int quantity) {
        long totalReward = 0L;
        for (Rank key : prizeMap.keySet()) {
            int reward = key.getReward();
            int count = prizeMap.get(key);
            totalReward += ((long) reward * count);
        }

        return (double) totalReward / (quantity * LOTTO_PER_MONEY);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Prize prize = (Prize) other;
        return Objects.equals(prizeMap, prize.prizeMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prizeMap);
    }
}
