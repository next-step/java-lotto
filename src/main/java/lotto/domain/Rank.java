package lotto.domain;

import java.util.Arrays;
import java.util.Optional;

public enum Rank {
    FIFTH(3, false,5_000),
    FOURTH(4,false, 50_000),
    THIRD(5, false,1_500_000),
    SECOND(5, true,30_000_000),
    FIRST(6, false,2_000_000_000),
    ;

    public int countOfMatch;
    public boolean bonusMatch;
    public int winningMoney;

    Rank(int countOfMatch, boolean bonusMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.bonusMatch = bonusMatch;
        this.winningMoney = winningMoney;
    }

    public static Optional<Rank> valueOf(int matchedCount, boolean bonusMatch) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.isMatched(matchedCount, bonusMatch))
                .findFirst();
    }

    private boolean isMatched(int matchedCount, boolean bonusMatch) {
        return this.countOfMatch == matchedCount && this.bonusMatch == bonusMatch;
    }

}
