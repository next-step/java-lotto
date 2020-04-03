package lotto.domain;

import java.util.Arrays;

public enum Prize {
    MISS(0, 0),
    FOURTH(3, 5000),
    THIRD(4, 50_000),
    SECOND(5, 150_0000),
    FIRST(6, 200_000_0000);

    private int match;
    private int amount;

    Prize(int match, int amount) {
        this.match = match;
        this.amount = amount;
    }

    public int getMatch() {
        return match;
    }

    public int getAmount() {
        return amount;
    }

    static Prize of(int match) {
        return Arrays.stream(values())
                .filter(v -> match == v.match)
                .findAny()
                .orElse(Prize.MISS);
    }
}
