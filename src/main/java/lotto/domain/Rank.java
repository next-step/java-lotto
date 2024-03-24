package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Rank {
    FIRST(6, false, 2_000_000_000L),
    SECOND(5, true, 30_000_000L),
    THIRD(5, false, 1_500_000L),
    FOURTH(4, false, 50_000L),
    FIFTH(3, false, 5_000L),
    NEXT_CHANCE(0, false, 0L),
    ;

    private final LottoMatchCount matchCount;
    private final boolean needBonusMatch;
    private final long winnings;

    Rank(int matchCount, boolean needBonusMatch, long winnings) {
        this.matchCount = new LottoMatchCount(matchCount);
        this.needBonusMatch = needBonusMatch;
        this.winnings = winnings;
    }

    public static Rank valueOf(LottoMatchCount matchCount, boolean bonusMatch) {
        assertMatchCountLessThanFirstPrize(matchCount);

        return Arrays.stream(values())
                .filter(type -> type.match(matchCount, bonusMatch))
                .findFirst()
                .orElse(Rank.NEXT_CHANCE);
    }

    public static Rank valueOf(int matchCount) {
        assertMatchCountLessThanFirstPrize(new LottoMatchCount(matchCount));

        return Arrays.stream(values())
                .filter(type -> type.matchCount.equals(matchCount))
                .findFirst()
                .orElse(Rank.NEXT_CHANCE);
    }

    public static List<Rank> winRanks() {
        return Arrays.stream(values())
                .filter(type -> type.winnings > 0L)
                .sorted((a, b) -> Long.compare(a.winnings, b.winnings))
                .collect(Collectors.toList());
    }

    private static void assertMatchCountLessThanFirstPrize(LottoMatchCount matchCount) {
        if (FIRST.matchCount.smallerThan(matchCount)) {
            throw new IllegalArgumentException("로또는 그 이상의 당첨이 불가능할텐데요.");
        }
    }

    public int matchCount() {
        return this.matchCount.value();
    }

    public long winnings() {
        return this.winnings;
    }

    public boolean needBonusMatch() {
        return this.needBonusMatch;
    }

    private boolean match(LottoMatchCount matchCount, boolean bonusMatch) {
        if (this.needBonusMatch) {
            return countMatch(matchCount) && bonusMatch(bonusMatch);
        }
        return countMatch(matchCount);
    }

    private boolean countMatch(LottoMatchCount matchCount) {
        return this.matchCount.equals(matchCount);
    }

    private boolean bonusMatch(boolean bonusMatch) {
        return this.needBonusMatch && bonusMatch;
    }

}
