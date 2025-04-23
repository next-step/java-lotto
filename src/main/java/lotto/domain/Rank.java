package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6,2_000_000_000, new CountMatcher(6)),
    SECOND(5, 30_000_000, new CountAndBonusMatcher(5,true)),
    THIRD(5, 1_500_000, new CountAndBonusMatcher(5, false)),
    FOURTH(4, 50_000, new CountMatcher(4)),
    FIFTH(3, 5_000, new CountMatcher(3)),
    MISS( 0,0, new MissMatcher());

    private final int countOfMatch;
    private final int winningMoney;
    private final RankMatcher matcher;


    Rank(int countOfMatch, int winningMoney, RankMatcher matcher) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.matcher = matcher;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

   public static Rank find(int count, boolean bonus) {
        return Arrays.stream(values()).filter(rank -> rank.matcher.match(count,bonus)).findFirst().orElse(MISS);
   }

}
