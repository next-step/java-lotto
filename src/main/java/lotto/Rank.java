package lotto;

public enum Rank {

    MISS(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private final int countOfMatch;
    private final int winningMoney;

    Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        validate(countOfMatch);

        if (getRankOfSecond(matchBonus)) {
            return SECOND;
        }

        if (getRankOfFifth(countOfMatch)) {
            return FIFTH;
        }

        for (Rank rank : Rank.values()) {
            return getRankOfEtc(countOfMatch, rank);
        }

        throw new IllegalArgumentException("일치하는 당첨 개수가 없습니다. 당첨 개수를 확인 해주세요");
    }

    private static boolean getRankOfFifth(int countOfMatch) {
        return countOfMatch == Rank.FIFTH.getCountOfMatch();
    }

    private static boolean getRankOfSecond(boolean matchBonus) {
        return matchBonus;
    }

    private static Rank getRankOfEtc(int countOfMatch, Rank rank) {
        if (countOfMatch == rank.getCountOfMatch()) {
            return rank;
        }

        return MISS;
    }

    private static void validate(int countOfMatch) {
        if (countOfMatch < 0) {
            throw new IllegalArgumentException("맞춘 개수는 0보다 작을 수 없습니다.");
        }

        if (countOfMatch > 6) {
            throw new IllegalArgumentException("맞춘 개수는 6보다 클 수 없습니다.");
        }
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}