package lotto.domain;


import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private static final Map<LottoMatchKey, LottoRank> RANK_MATCH_COUNT_MAP = Collections.unmodifiableMap(
            Arrays.stream(LottoRank.values()).collect(
                    Collectors.toMap(value -> new LottoMatchKey(value.matchCount, value.matchBonus),
                                     Function.identity())));

    private static final int ONLY_INCLUDE_BONUS_MATCH_COUNT = 5;

    private final int matchCount;
    private final int reward;
    private final boolean matchBonus;

    LottoRank(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
        this.matchBonus = false;
    }

    LottoRank(int matchCount, int reward, boolean matchBonus) {
        this.matchCount = matchCount;
        this.reward = reward;
        this.matchBonus = matchBonus;
    }

    public static LottoRank of(int matchCount, boolean matchBonus) {
        LottoMatchKey matchKey = buildMatchKey(matchCount, matchBonus);
        if (Objects.isNull(RANK_MATCH_COUNT_MAP.get(matchKey))) {
            return LottoRank.NONE;
        }
        return RANK_MATCH_COUNT_MAP.get(matchKey);
    }

    public static LottoMatchKey buildMatchKey(int matchCount, boolean matchBonus) {
        if (matchCount == ONLY_INCLUDE_BONUS_MATCH_COUNT) {
            return new LottoMatchKey(matchCount, matchBonus);
        }
        return new LottoMatchKey(matchCount, false);
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public int getReward() {
        return this.reward;
    }

    private static class LottoMatchKey {
        private final int count;
        private final boolean bonus;

        public LottoMatchKey(int count, boolean bonus) {
            this.count = count;
            this.bonus = bonus;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            LottoMatchKey that = (LottoMatchKey) o;
            return count == that.count && bonus == that.bonus;
        }

        @Override
        public int hashCode() {
            return Objects.hash(count, bonus);
        }
    }
}
