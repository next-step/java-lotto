package lotto.domain;

public enum LottoRank {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000);

    private final int matchCount;
    private final boolean containsBonusNumber;
    private final int prizeMoney;

    LottoRank(int matchCount, boolean containsBonusNumber, int prizeMoney) {
        this.matchCount = matchCount;
        this.containsBonusNumber = containsBonusNumber;
        this.prizeMoney = prizeMoney;
    }

    public static LottoRank getRank(int matchCount) {
        return LottoRank.getRank(matchCount, false);
    }

    public static LottoRank getRank(int matchCount, boolean containsBonusNumber) {
        for (LottoRank prize : values()) {
            if (prize.matchCount == matchCount && prize.containsBonusNumber == containsBonusNumber) {
                return prize;
            }
        }
        return null;
    }

    public int getPrizeMoney(int count) {
        return prizeMoney * count;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isContainsBonusNumber() {
        return this.containsBonusNumber;
    }
}
