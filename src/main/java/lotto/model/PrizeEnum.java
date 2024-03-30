package lotto.model;

import java.util.HashMap;
import java.util.Map;

public enum PrizeEnum {
    FIRST(6, 2000000000L, false),
    SECOND(5, 30000000L, true),
    THIRD(5, 1500000L, false),
    FOURTH(4, 50000L, false),
    FIFTH(3, 5000L, false),
    MISS(0, 0L, false);

    private static final Map<Integer, Boolean> matchedCountToBonusMap = new HashMap<>();
    private static final Map<PrizeKey, PrizeEnum> prizeMap = new HashMap<>();

    private final int matchedCount;
    private final Long prize;
    private final boolean isBonusMatched;

    PrizeEnum(int matchedCount, Long prize, boolean isBonusMatched) {
        this.matchedCount = matchedCount;
        this.prize = prize;
        this.isBonusMatched = isBonusMatched;
    }

    static {
        for (PrizeEnum prizeEnum : PrizeEnum.values()) {
            matchedCountToBonusMap.putIfAbsent(prizeEnum.matchedCount, prizeEnum.isBonusMatched);
            prizeMap.put(new PrizeKey(prizeEnum.matchedCount, prizeEnum.isBonusMatched), prizeEnum);
        }
    }

    public Long getPrize() {
        return prize;
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public boolean isBonusMatched() {
        return isBonusMatched;
    }

    public static PrizeEnum getPrizeFrom(int matchedCount, boolean isBonusMatched) {
        return prizeMap.getOrDefault(new PrizeKey(matchedCount, isBonusMatched), PrizeEnum.MISS);
    }

    public static boolean isBonusMatchedFrom(int matchedCount) {
        return matchedCountToBonusMap.getOrDefault(matchedCount, false);
    }

    private static class PrizeKey {
        private final int matchedCount;
        private final boolean isBonusMatched;

        public PrizeKey(int matchedCount, boolean isBonusMatched) {
            this.matchedCount = matchedCount;
            this.isBonusMatched = isBonusMatched;
        }

        @Override
        public int hashCode() {
            return 31 * matchedCount + (isBonusMatched ? 1 : 0);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            PrizeKey key = (PrizeKey) obj;
            return matchedCount == key.matchedCount && isBonusMatched == key.isBonusMatched;
        }
    }
}
