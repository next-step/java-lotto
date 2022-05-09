package lotto.domain;

import java.util.Arrays;

public enum Ranking {
    FIRST(6, 2000000000, 0),
    SECOND(5, 30000000, 1),
    THIRD(5, 1500000, 0),
    FOURTH(4, 50000, 0),
    FIFTH(3, 5000, 0),
    MISS(0, 0, 0);

    private final int requireBonusCount;
    private final int matchCount;
    private final int money;

    Ranking(int matchCount, int money, int requireBonusCount) {
        this.matchCount = matchCount;
        this.money = money;
        this.requireBonusCount = requireBonusCount;
    }

    public static Ranking findMatchRanking(MatchResult matchResult) {
        return Arrays.stream(Ranking.values())
                .filter(ranking -> ranking.isEqualRanking(matchResult.getMatchCount(), matchResult.getMatchBonus()))
                .findAny()
                .orElse(MISS);
    }

    private boolean isEqualRanking(int matchCount, int matchBonus) {
        return this.matchCount == matchCount && this.requireBonusCount <= matchBonus;
    }

    public boolean isWinner() {
        return this != MISS;
    }

    public int getMoney() {
        return money;
    }


    @Override
    public String toString() {
        return matchCount +"개 일치 (" + money + ")원";
    }
}
