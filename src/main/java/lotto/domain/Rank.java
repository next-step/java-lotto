package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private int countOfMatch;
    private boolean bonusMatch;
    private int winningMoney;

    Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.bonusMatch = false;
        this.winningMoney = winningMoney;

    }

    Rank(int countOfMatch, boolean bonusMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.bonusMatch = bonusMatch;
        this.winningMoney = winningMoney;
    }

    public static int valueOf(int matchCount, boolean bonus) {
        if(matchCount==5) {
            return Arrays.stream(Rank.values())
                    .filter(rank ->
                            rank.countOfMatch == matchCount && rank.bonusMatch==bonus
                    )
                    .findAny()
                    .orElseThrow(() -> new IllegalArgumentException())
                    .winningMoney;
        }

        return Arrays.stream(Rank.values())
                .filter(rank -> rank.countOfMatch == matchCount)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException())
                .winningMoney;

    }

}
