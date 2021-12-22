package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class PrizeStatistic {
    private static final int DEFAULT_VALUE = 0;
    private static final int ADD_VALUE = 1;


    private final Map<PrizeType, Integer> prizeStat = new EnumMap<>(PrizeType.class);

    public void put(PrizeType prizeType) {
        this.prizeStat.put(prizeType, prizeStat.getOrDefault(prizeType, DEFAULT_VALUE) + ADD_VALUE);
    }

    public Integer getOrDefault(PrizeType prizeType) {
        return prizeStat.getOrDefault(prizeType, DEFAULT_VALUE);
    }
}
