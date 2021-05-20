package lotto.core.round;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, true),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private final int countOfMatch;
    private final int winningMoney;
    private final boolean isDuplicateMatch;

    Rank(int countOfMatch, int winningMoney) {
        this(countOfMatch, winningMoney, false);
    }

    Rank(int countOfMatch, int winningMoney, boolean isDuplicateMatch) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.isDuplicateMatch = isDuplicateMatch;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        if (countOfMatch == FIFTH.countOfMatch) {
            return FIFTH;
        }
        if (countOfMatch == FOURTH.countOfMatch) {
            return FOURTH;
        }
        if (countOfMatch == SECOND.countOfMatch) {
            return matchBonus ? SECOND : THIRD;
        }
        if (countOfMatch == FIRST.countOfMatch) {
            return FIRST;
        }

        return MISS;
    }

    public int countOfMatch() {
        return countOfMatch;
    }

    public int winningMoney() {
        return winningMoney;
    }

    public boolean isDuplicateMatch() {
        return isDuplicateMatch;
    }

    public boolean ifWinning() {
        return this.countOfMatch >= FIFTH.countOfMatch;
    }

}
