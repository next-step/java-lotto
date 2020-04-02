package lotto2.domain;

import java.util.Arrays;

public enum Prize {
    FOURTH(3, 5000),
    THIRD(4, 1500_000),
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
                .orElseThrow(() -> new IllegalArgumentException("당첨되지 않았습니다."));
    }
}
