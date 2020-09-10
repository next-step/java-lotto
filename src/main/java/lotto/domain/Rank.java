package lotto.domain;

import java.util.Arrays;

public enum Rank {

    FirstPlace(6, 2000000000),
    SecondPlace(5, 1500000),
    ThirdPlace(4, 50000),
    FourthPlace(3, 5000),
    FifthPlace(2, 0),
    SixthPlace(1, 0),
    SeventhPlace(0, 0);


    private int matchCount;
    private int winnings;
    Rank(int matchCount, int winnings) {
        this.matchCount = matchCount;
        this.winnings = winnings;
    }

    public static Rank create(int matchCount) {
        return Arrays.stream(Rank.values()).filter(rank -> rank.hasRank(matchCount))
                                           .findAny()
                                           .orElse(null);
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
