package domain;

import java.util.Arrays;
import java.util.Map;

public enum Rank {

    FIRST(6, false, 2_000_000_000L),
    SECOND(5, true, 30_000_000L),
    THIRD(5, false, 1_500_000L),
    FOURTH(4, false, 50_000L),
    FIFTH(3, false, 5_000L),
    NONE(0, false, 0L);

    private final long matchLottoNumber;
    private final boolean hasToCheckBonus;
    private final long prize;

    Rank(final long matchLottoNumber, final boolean hasToCheckBonus, final long prize) {
        this.matchLottoNumber = matchLottoNumber;
        this.hasToCheckBonus = hasToCheckBonus;
        this.prize = prize;
    }

    public static Rank resolveRank(final long matchLottoNumber, final boolean containsBonus) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.match(matchLottoNumber, containsBonus))
                .findAny()
                .orElseThrow(() -> new UnsupportedOperationException("지원하지 않는 등수입니다."));
    }

    public static long calculatePrize(final Map<Rank, Long> statistic) {
        return statistic.entrySet().stream()
                .mapToLong(Rank::calculatePrize)
                .sum();
    }

    private static long calculatePrize(final Map.Entry<Rank, Long> entry) {
        return entry.getKey().prize * entry.getValue();
    }

    private boolean match(final long matchLottoNumber, final boolean containsBonus) {
        if (this.matchLottoNumber > matchLottoNumber) {
            return false;
        }
        if (this.hasToCheckBonus) {
            return containsBonus;
        }
        return true;
    }
}
