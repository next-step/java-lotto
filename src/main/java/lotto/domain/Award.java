package lotto.domain;

import java.util.Arrays;

public enum Award {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    BANG2(2, 0),
    BANG1(1, 0),
    BANG0(0, 0),
    UNIDENTIFIED(-1, 0);
    private final int matchNumbers;
    private final int amount;

    Award(int matchNumbers, int amount) {
        this.matchNumbers = matchNumbers;
        this.amount = amount;
    }

    public static Award findBy(int matchNumbers) {
        return Arrays.stream(values()).filter(award -> award.matchNumbers == matchNumbers).findFirst()
                .orElseThrow(() -> new RuntimeException());
    }

    public int getMatchNumbers() {
        return matchNumbers;
    }

    public int getAmount() {
        return amount;
    }

}
