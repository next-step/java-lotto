package lotto;

import java.util.stream.Stream;

public enum LottoRank {
    MISS(0, 0),
    FOURTH(3, 5000),
    THIRD(4, 50000),
    SECOND(5, 1500000),
    FIRST(6, 2000000000);

    private int matchCount;
    private int winReward;

    LottoRank(int matchCount, int winReward) {
        this.matchCount = matchCount;
        this.winReward = winReward;
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

    public boolean isMiss() {
        return this == MISS;
    }

    public int rankOfReward(int rankCount) {
        return winReward * rankCount;
    }
}
