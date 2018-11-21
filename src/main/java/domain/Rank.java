package domain;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    static final int LIMIT_MINIMUM_COUNT = 3;
    static final int SECOND_COUNT = 5;

    private int countOfMatch;
    private int winningMoney;

    private Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        Rank[] ranks = values();
        // TODO 일치하는 수를 로또 등수로 변경한다. enum 값 목록은 "Rank[] ranks = values();"와 같이 가져올 수 있다.
        if(countOfMatch < LIMIT_MINIMUM_COUNT) {
            return MISS;
        }

        for(Rank rank : ranks) {
            if (countOfMatch == SECOND_COUNT) {
                return matchBonus ? SECOND : THIRD;
            }

            if(rank.countOfMatch == countOfMatch) {
                return rank;
            }
        }

        return null;
    }
}