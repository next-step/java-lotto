package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Ranks {
    private static final int FIFTH_MATCHING_COUNT = 2;
    private final List<Rank> value;

    public Ranks(List<Rank> value) {
        this.value = value;
    }

    public Map<Rank, Integer> convertToMap() {
        Map<Rank, Integer> result = init();
        value.stream()
                .filter(rank -> rank.getMatchingNumberCount() > FIFTH_MATCHING_COUNT)
                .forEach(rank -> result.put(rank, result.getOrDefault(rank, 0) + 1));

        return result;
    }

    private Map<Rank, Integer> init() {
        Map<Rank, Integer> result = new EnumMap<>(Rank.class);
        result.put(Rank.FIRST, 0);
        result.put(Rank.SECOND, 0);
        result.put(Rank.THIRD, 0);
        result.put(Rank.FOURTH, 0);
        result.put(Rank.FIFTH, 0);

        return result;
    }

    public double getAllPrizeMoney() {
        return value.stream()
                .mapToDouble(Rank::getPrizeMoney)
                .sum();
    }
}
