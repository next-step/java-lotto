package lotto.domain;

import java.util.List;

public enum LottoRank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    public static final List<LottoRank> RANKING_ORDER = List.of(
        FIRST, SECOND, THIRD, FOURTH, FIFTH
    );
    private final int matchCount;
    private final boolean requiresBonusNumber;
    private final int prizeMoney;

    LottoRank(int matchCount, boolean requiresBonusNumber, int prizeMoney) {
        this.matchCount = matchCount;
        this.requiresBonusNumber = requiresBonusNumber;
        this.prizeMoney = prizeMoney;
    }

    public static LottoRank getRank(int matchCount, boolean bonusMatched) {
        for (LottoRank rank : RANKING_ORDER) {
            if (rank.matches(matchCount, bonusMatched)) {
                return rank;
            }
        }
        return NONE;
    }

    private boolean matches(int matchCount, boolean bonusMatched) {
        if (this.matchCount != matchCount) {
            return false;
        }
        if (this.requiresBonusNumber) {
            return bonusMatched;
        }
        return true;
    }

    public int getPrizeMoney(int count) {
        return prizeMoney * count;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean requiresBonusNumber() {
        return requiresBonusNumber;
    }

    public boolean isWinning() {
        return this != NONE;
    }
}
