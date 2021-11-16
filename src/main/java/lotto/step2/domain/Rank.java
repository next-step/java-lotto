package lotto.step2.domain;

public enum Rank {

    FIRST(6, 2_000_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private int countOfMatch;
    private int prizeMoney;

    Rank(int countOfMatch, int prizeMoney) {
        this.countOfMatch = countOfMatch;
        this.prizeMoney = prizeMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public static Rank valueOf(int countOfMatch) {
        if (FIFTH.countOfMatch == countOfMatch) return FIFTH;
        if (FOURTH.countOfMatch == countOfMatch) return FOURTH;
        if (THIRD.countOfMatch == countOfMatch) return THIRD;
        if (FIRST.countOfMatch == countOfMatch) return FIRST;
        return MISS;
    }

}
