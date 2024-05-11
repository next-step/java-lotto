import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 300_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    MISS(0, 0, false);

    private final int countOfMatch;
    private final int winningMoney;
    private final boolean isBonus;

    private Rank(int countOfMatch, int winningMoney, boolean isBonus) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.isBonus = isBonus;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public boolean getIsBonus() {
        return isBonus;
    }

    public static Rank valueOf(int countOfMatch, boolean isWinningBonus) {
        return Arrays.stream(values())
                .filter(i -> i.getCountOfMatch() == countOfMatch && i.getIsBonus() == isWinningBonus)
                .findFirst()
                .orElse(MISS);
    }
}
