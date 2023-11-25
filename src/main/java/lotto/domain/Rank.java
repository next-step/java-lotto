package lotto.domain;

import java.util.Arrays;

public enum Rank {
    MISS(0, BonusMatching.IRRELEVANT, 0),
    FIFTH(3,  BonusMatching.IRRELEVANT, 5_000),
    FOURTH(4,  BonusMatching.IRRELEVANT, 50_000),
    THIRD(5,   BonusMatching.FALSE , 1_500_000),
    SECOND(5,   BonusMatching.TRUE , 30_000_000),
    FIRST(6,  BonusMatching.FALSE , 2_000_000_000),
    ;

    private final int countOfMatch;
    private final BonusMatching bonusMatching;
    private final long winningMoney;

    Rank(int countOfMatch, BonusMatching bonusMatching, long winningMoney) {
        this.countOfMatch = countOfMatch;
        this.bonusMatching = bonusMatching;
        this.winningMoney = winningMoney;
    }

    public long calculateRankByCount(int count) {
        return winningMoney * count;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public long getWinningMoney() {
        return winningMoney;
    }

    public BonusMatching getBonusMatching() {
        return bonusMatching;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.countOfMatch == countOfMatch && rank.bonusMatching.match(matchBonus))
                .findFirst()
                .orElse(MISS);
    }
}
