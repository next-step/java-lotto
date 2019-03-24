package lotto.domain;

public enum Rank {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    SIXTH(2, 0, false),
    SEVENTH(1, 0, false),
    NONE(0, 0, false);

    private int countOfMatch;
    private long money;
    private boolean hasBonus;

    Rank(int countOfMatch, long money, boolean hasBonus) {
        this.countOfMatch = countOfMatch;
        this.money = money;
        this.hasBonus = hasBonus;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public long getMoney() {
        return money;
    }

    public static Rank valueOf(int matchingCount, boolean hasBonus) {
        for (Rank rank : Rank.values()) {
            if (matchingCount == Rank.SECOND.getCountOfMatch()) {
                if (hasBonus) {
                    return Rank.SECOND;
                }

                return Rank.THIRD;
            }

            if (rank.countOfMatch == matchingCount) {
                return rank;
            }
        }

        throw new IllegalArgumentException("NOT EXISTS");
    }

    public boolean isInTop5() {
        if (this == Rank.NONE || this == Rank.SEVENTH || this == Rank.SIXTH) {
            return false;
        }

        return true;
    }

    public long calculateWinningMoney(RankCount rankCount) {
        return rankCount.calculate(money);
    }

    @Override
    public String toString() {
        String output = String.format("%d개 일치(%d원)", countOfMatch, money);

        if (hasBonus) {
            output = output.join(", ", output, "보너스 볼 일치");
        }

        return output;
    }
}
