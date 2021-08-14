package step3.lotto;

public enum Rank {

    FIRST(6,2_000_000_000),
    SECOND(5,30_000_000),
    THIRD(5,1_500_000),
    FOURTH(4,50_000),
    FIFTH(3,5_000),
    MISS(0,0);

    private final long countOfMatch;
    private final long prizeMoney;

    Rank(long countOfMatch, long prizeMoney) {
        this.countOfMatch = countOfMatch;
        this.prizeMoney = prizeMoney;
    }

    public static Rank valueOf(long countOfMatch, boolean matchBonus) {
        if (countOfMatch == FIRST.getCountOfMatch()) {
            return Rank.FIRST;
        }

        if (countOfMatch == SECOND.getCountOfMatch() && matchBonus) {
            return Rank.SECOND;
        }

        if (countOfMatch == THIRD.getCountOfMatch()) {
            return Rank.THIRD;
        }

        if (countOfMatch == FOURTH.getCountOfMatch()) {
            return Rank.FOURTH;
        }

        if (countOfMatch == FIFTH.getCountOfMatch()) {
            return Rank.FIFTH;
        }

        return Rank.MISS;
    }

    public long getCountOfMatch() {
        return countOfMatch;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }
}
