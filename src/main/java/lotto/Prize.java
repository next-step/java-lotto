package lotto;

import java.util.Arrays;

public enum Prize {
    FIFTH(3, 5000, "5등"),
    FOURTH(4, 50000, "4등"),
    THIRD(5, 1500000, "3등"),
    SECOND(5, 30000000, "2등(보너스 볼 일치)"),
    FIRST(6, 2000000000, "1등");

    private int rank;
    private int amount;
    private String description;

    Prize(int rank, int amount, String description) {
        this.rank = rank;
        this.amount = amount;
        this.description = description;
    }

    static Prize of(String rank) {
        return Arrays.stream(values())
                .filter(v -> rank.equals(v.rank))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("당첨되지 않았습니다."));
    }
}
