package lotto.domain;

import java.util.Arrays;

public enum Rank {

    FirstPlace(6, 2000000000),
    SecondPlace(5, 30000000),
    ThirdPlace(5, 1500000),
    FourthPlace(4, 50000),
    FifthPlace(3, 5000),
    SixthPlace(2, 0),
    SeventhPlace(1, 0),
    EightPlace(0, 0);


    private int matchCount;
    private int winnings;
    private boolean isMatchBonus;
    Rank(int matchCount, int winnings) {
        this.matchCount = matchCount;
        this.winnings = winnings;
    }

    public static Rank create(int matchCount) {
        return Arrays.stream(Rank.values()).filter(rank -> rank.hasRank(matchCount))
                                           .findFirst()
                                           .orElse(null);
    }

    public static Rank create(int matchCount, boolean isMatchBonus) {
        if(matchCount == 5) {
           return createSecondOrThird(isMatchBonus);
        }
        return create(matchCount);
    }

    public static Rank createSecondOrThird(boolean isMatchBonus) {
        if(isMatchBonus){
            return SecondPlace;
        }

        return ThirdPlace;
    }

    public boolean hasRank(int matchCount) {
        return this.matchCount == matchCount;
    }

    public int getWinnings() {
        return this.winnings;
    }

    public int getMatchCount() {
        return this.matchCount;
    }



}
