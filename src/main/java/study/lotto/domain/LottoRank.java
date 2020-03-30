package study.lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public enum LottoRank {
    FIRST(2_000_000_000, 6, false),
    SECOND(30_000_000, 5, true),
    THIRD(1_500_000, 5, false),
    FOURTH(50_000, 4, false),
    FIFTH(5_000, 3, false),
    MISS(0, 0, false);

    private static Map<ValueKey, LottoRank> valueToLottoRank =
            new HashMap<>();

    private int prize;
    private int matchCount;
    private boolean matchBonus;

    LottoRank(int prize, int matchCount, boolean matchBonus) {
        this.prize = prize;
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
    }

    static {
        for (LottoRank lottoRank : LottoRank.values()) {
            ValueKey valueKey = new ValueKey(lottoRank.matchCount,
                    lottoRank.matchBonus);
            valueToLottoRank.put(valueKey, lottoRank);
        }
    }

    public static LottoRank valueOf(Integer matchCount, boolean matchBonus) {
        LottoRank lottoRank = valueToLottoRank.get(new ValueKey(matchCount,
                matchBonus));
        if(Objects.isNull(lottoRank)) {
            return MISS;
        }
        return lottoRank;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isMatchBonus() {
        return matchBonus;
    }

    private static class ValueKey {
        private Integer matchCount;
        private boolean matchBonus;

        private ValueKey(Integer matchCount, boolean matchBonus) {
            this.matchCount = matchCount;
            this.matchBonus = matchBonus;
        }

        @Override public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ValueKey valueKey = (ValueKey) o;
            return matchBonus == valueKey.matchBonus &&
                    Objects.equals(matchCount, valueKey.matchCount);
        }

        @Override public int hashCode() {
            return Objects.hash(matchCount, matchBonus);
        }
    }
}
