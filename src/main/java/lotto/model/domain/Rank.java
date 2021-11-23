package lotto.model.domain;

public enum Rank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private int countOfMatch;
    private long winningMoney;

    Rank(int countOfMatch, long winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public long getWinningMoney() {
        return winningMoney;
    }

    public boolean haveBonus() {
        return this == Rank.SECOND;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        for(Rank rank : values()) {
            if(countOfMatch == SECOND.countOfMatch) {
                return matchBonus ? SECOND : THIRD;
            }
            if (rank.countOfMatch == countOfMatch) {
                return rank;
            }
        }
        return MISS;
    }
}
