package domain;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Rank {

    FIRST(
            6,
            false,
            (matchCount, ignored) -> matchCount == 6,
            2_000_000_000L
    ),
    SECOND(
            5,
            true,
            (matchCount, bonus) -> matchCount == 5 && bonus,
            30_000_000L
    ),
    THIRD(
            5,
            false,
            (matchCount, ignored) -> matchCount == 5,
            1_500_000L
    ),
    FOURTH(
            4,
            false,
            (matchCount, ignored) -> matchCount == 4,
            50_000L
    ),
    FIFTH(
            3,
            false,
            (matchCount, ignored) -> matchCount == 3,
            5_000L
    ),
    NONE(
            0,
            false,
            (matchCount, ignored) -> matchCount < 3,
            0L
    );

    private final long matchLottoNumber;
    private final boolean containsBonus;
    private final BiPredicate<Long, Boolean> criteria;
    private final long prize;

    Rank(
            final long matchLottoNumber,
            final boolean containsBonus,
            final BiPredicate<Long, Boolean> criteria,
            final long prize
    ) {
        this.matchLottoNumber = matchLottoNumber;
        this.containsBonus = containsBonus;
        this.criteria = criteria;
        this.prize = prize;
    }

    public static Rank from(final long matchCount, final boolean bonus) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.match(matchCount, bonus))
                .findAny()
                .orElseThrow(() -> new UnsupportedOperationException(
                        "지원하지 않는 등수입니다. 일치 개수: " + matchCount + " 보너스 일치 여부" + bonus)
                );
    }

    public long calculatePrize(final long count) {
        return this.prize * count;
    }

    public long getMatchLottoNumber() {
        return matchLottoNumber;
    }

    public boolean containsBonus() {
        return containsBonus;
    }

    public long getPrize() {
        return prize;
    }

    private boolean match(final long matchLottoNumber, final boolean containsBonus) {
        return criteria.test(matchLottoNumber, containsBonus);
    }
}
