package lotto.domain;

public enum Prize {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    SIXTH(2, 0),
    SEVENTH(1, 0),
    NONE(0, 0);

    private int countOfMatch;
    private long money;
    private boolean hasBonus;

    Prize(int countOfMatch, int money) {
        this.countOfMatch = countOfMatch;
        this.money = money;
    }

    Prize(int countOfMatch, long money, boolean hasBonus) {
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

    public static Prize valueOf(int matchingCount, boolean hasBonus) {
        for (Prize prize : Prize.values()) {
            if (matchingCount == Prize.SECOND.getCountOfMatch()) {
                if (hasBonus) {
                    return Prize.SECOND;
                }

                return Prize.THIRD;
            }

            if (prize.countOfMatch == matchingCount) {
                return prize;
            }
        }

        throw new IllegalArgumentException("NOT EXISTS");
    }

    public boolean isInTop5() {
        if (this == Prize.NONE || this == Prize.SEVENTH || this == Prize.SIXTH) {
            return false;
        }

        return true;
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
