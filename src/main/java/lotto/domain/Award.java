package lotto.domain;

import java.util.Arrays;

public enum Award {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    BANG(0, false, 0),
    UNIDENTIFIED(-1, false, 0);

    private final int matchNumbers;
    private final boolean bonus;
    private final int amount;

    Award(int matchNumbers, boolean bonus, int amount) {
        this.matchNumbers = matchNumbers;
        this.bonus = bonus;
        this.amount = amount;
    }

    public static Award findBy(long matchNumbers, boolean bonus) {
        return Arrays.stream(values())
                .filter(award -> award.matchNumbers == matchNumbers && award.bonus == bonus)
                .findFirst()
                .orElse(Award.BANG);
    }

    public int getMatchNumbers() {
        return matchNumbers;
    }

    public boolean isBonus() {
        return bonus;
    }

    public int getAmount() {
        return amount;
    }

}
