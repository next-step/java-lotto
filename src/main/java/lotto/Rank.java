package lotto;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private static final int MIN_MATCH_COUNT = 3;
    private int countOfMatch;
    private int winningMoney;

    private Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public Money prizePerRanking(int matchCount) {
        return new Money(winningMoney * matchCount);
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        //일치하는 수를 로또 등수로 변경. enum 값 목록은 Rank[] ranks = values(); 와 같이 가져올 수 있다.
        if(countOfMatch < MIN_MATCH_COUNT) return MISS;
        if(SECOND.match(countOfMatch)) {
            return matchBonus ? SECOND : THIRD;
        }
        return Rank.valueOf(countOfMatch);
    }

    public static Rank valueOf(int countOfMatch) {
        for(Rank rank : values()) {
            if(rank.match(countOfMatch)) {
                return rank;
            }
        }
        throw new IllegalArgumentException();
    }

    private boolean match(int countOfMatch) {
        return this.countOfMatch == countOfMatch;
    }

}
