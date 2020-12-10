package lotto;

public enum Rank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private final int countOfMatch;
    private final int winningMoney;

    Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        return null;
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