package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static java.util.Comparator.reverseOrder;
import static java.util.function.Predicate.not;
import static java.util.stream.Collectors.*;

public enum LottoRank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    private static final Map<MapKey, LottoRank> VALUE_MAP
            = Arrays.stream(values())
            .collect(toUnmodifiableMap(MapKey::new, e -> e));
    private static final List<LottoRank> RANK_VALUES
            = Arrays.stream(values())
            .sorted(reverseOrder())
            .filter(not(LottoRank::isNone))
            .collect(toUnmodifiableList());

    private final long matchedCount;
    private final boolean isMatchedBonusBall;
    private final long reward;

    LottoRank(long matchedCount, boolean isMatchedBonusBall, long reward) {
        this.matchedCount = matchedCount;
        this.isMatchedBonusBall = isMatchedBonusBall;
        this.reward = reward;
    }

    public static Map<LottoRank, Integer> makeRankMap() {
        return Arrays.stream(values())
                .sequential()
                .collect(toMap(e -> e, e -> 0));
    }

    public static LottoRank findLottoRank(long matchedCount, boolean isMatchedBonusBall) {
        return VALUE_MAP.getOrDefault(new MapKey(matchedCount, isMatchedBonusBall), NONE);
    }

    public static List<LottoRank> getRankValues() {
        return RANK_VALUES;
    }

    public long getMatchedCount() {
        return matchedCount;
    }

    public boolean isMatchedBonusBall() {
        return isMatchedBonusBall;
    }

    public long getReward() {
        return reward;
    }

    public boolean isNone() {
        return NONE.equals(this);
    }

    public boolean isSecond() {
        return SECOND.equals(this);
    }

    private static class MapKey {

        private final long matchedCount;
        private final boolean isMatchedBonusBall;

        public MapKey(LottoRank lottoRank) {
            this(lottoRank.getMatchedCount(), lottoRank.isMatchedBonusBall());
        }

        public MapKey(long matchedCount, boolean isMatchedBonusBall) {
            this.matchedCount = matchedCount;
            this.isMatchedBonusBall = isMatchedBonusBall;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MapKey mapKey = (MapKey) o;
            return matchedCount == mapKey.matchedCount && isMatchedBonusBall == mapKey.isMatchedBonusBall;
        }

        @Override
        public int hashCode() {
            return Objects.hash(matchedCount, isMatchedBonusBall);
        }
    }

}