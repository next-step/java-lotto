package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class Result {

    private final Map<Rank, Integer> result = new EnumMap<>(Rank.class);

    public Result() {
        for (Rank value : Rank.values()) {
            result.put(value, 0);
        }
    }

    public void put(Rank rank) {
        result.put(rank, result.get(rank) + 1);
    }

    public int countRank(Rank value) {
        return result.get(value);
    }
}
