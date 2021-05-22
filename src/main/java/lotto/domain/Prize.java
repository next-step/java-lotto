package lotto.domain;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public enum Prize {
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000),
    NONE(0, 0);

    private final int matchCount;
    private final int rewardPrice;

    Prize(int matchCount, int rewardPrice) {
        this.matchCount = matchCount;
        this.rewardPrice = rewardPrice;
    }

    public static Prize valueOf(int matchCount, boolean matchBonus) {
        Prize result = Arrays.stream(values())
                .filter(prize -> prize.matchCount == matchCount)
                .findFirst()
                .orElse(NONE);

        if (result.matchCount == 5 && matchBonus) {
            return SECOND;
        }

        return result;
    }

    public int calculateProfit(int count) {
        return this.rewardPrice * count;
    }

    public static Map<Prize, Integer> defaultResultMap() {
        Map<Prize, Integer> defaultMap = new LinkedHashMap<>();
        for (Prize prize : values()) {
            defaultMap.put(prize, 0);
        }
        return defaultMap;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getRewardPrice() {
        return rewardPrice;
    }
}
