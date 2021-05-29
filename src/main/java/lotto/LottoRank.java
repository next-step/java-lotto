package lotto;

import java.util.stream.Stream;

public enum LottoRank {
    MISS(0, 0, false),
    FIFTH(3, 5_000, false),
    FOURTH(4, 50_000, false),
    THIRD(5, 1_500_000, false),
    SECOND(5, 30_000_000, true),
    FIRST(6, 2_000_000_000, false);

    private int matchCount;
    private int winReward;
    private boolean isMatchBonus;

    LottoRank(int matchCount, int winReward, boolean isMatchBonus) {
        this.matchCount = matchCount;
        this.winReward = winReward;
        this.isMatchBonus = isMatchBonus;
    }

    public boolean isSecond() {
        return this == SECOND;
    }

    public boolean isThird() {
        return this == THIRD;
    }

    public boolean isMiss() {
        return this == MISS;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinReward() {
        return winReward;
    }

    public static LottoRank searchRank(int countOfMatchUserLotto) {
        return Stream.of(values())
                .filter(LottoRank -> LottoRank.matchCount == countOfMatchUserLotto)
                .findFirst()
                .orElse(MISS);
    }

    public static LottoRank searchBonusRank(int countOfMatchUserLotto, boolean isMatchBonus) {
        return Stream.of(values())
                .filter(LottoRank -> LottoRank.matchCount == countOfMatchUserLotto && LottoRank.isMatchBonus == isMatchBonus)
                .findFirst()
                .get();

    }
}
