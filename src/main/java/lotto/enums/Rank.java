package lotto.enums;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private int countOfMatch;
    private int winningMoney;
    private static Rank foundRank;
    private static final int five = 5;

    private Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return this.countOfMatch;
    }

    public int getWinningMoney() {
        return this.winningMoney;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        // TODO 일치하는 수를 로또 등수로 변경한다. enum 값 목록은 "Rank[] ranks = values();"와 같이 가져올 수 있다.
        foundRank = Rank.MISS;
        Rank[] ranks = values();

        for (Rank rank : ranks) {
            matchRank(rank, countOfMatch, matchBonus);
        }
        return foundRank;
    }

    private static void matchRank(Rank rank, int countOfMatch, boolean matchBonus) {

        if (rank.countOfMatch == countOfMatch) {
            foundRank = rank;
        }

        if (matchBonus && foundRank.countOfMatch == five) {
            foundRank = Rank.SECOND;
        }
    }

}
