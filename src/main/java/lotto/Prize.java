package lotto;

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

    static Prize of(String rank) {
        return Arrays.stream(values())
                .filter(v -> rank.equals(v.match))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("당첨되지 않았습니다."));
    }
}
