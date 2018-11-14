package domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private int matchNumber;
    private int prizeMoney;

    Rank(int matchNumber, int prizeMoney) {
        this.matchNumber = matchNumber;
        this.prizeMoney = prizeMoney;
    }

    public static Rank valueOf(int matchCount, boolean matchBonus) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.isSameMatchNumber(matchCount))
                .filter(rank -> !rank.equals(SECOND) || matchBonus)
                .findFirst()
                .orElse(MISS);
    }

    public int getMatchNumber() {
        return this.matchNumber;
    }

    public int getPrizeMoney() {
        return this.prizeMoney;
    }

    public int getTotalPrizeMoney(int sameCount) {
        return this.prizeMoney * sameCount;
    }

    public boolean isSameMatchNumber(int matchNumber) {
        return this.matchNumber == matchNumber;
    }
}
