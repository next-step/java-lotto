package lotto.domain;

import java.util.Arrays;

public enum Match {
    NONE(0, new Money(0L), ""),
    THREE(3, new Money(5_000L), "3개 일치 (5000원)- %d개"),
    FOUR(4, new Money(50_000L), "4개 일치 (50000원)- %d개"),
    FIVE(5, new Money(1_500_000L), "5개 일치 (1500000원)- %d개"),
    SIX(6, new Money(2_000_000_000L), "6개 일치 (2000000000원)- %d개");

    private final int count;
    private final Money money;
    private final String message;

    Match(int count, Money money, String message) {
        this.count = count;
        this.money = money;
        this.message = message;
    }

    public static Match of(long count) {
        return Arrays.stream(values())
                .filter(match -> match.count == count)
                .findAny()
                .orElse(NONE);
    }

    public Money getMoney() {
        return money;
    }

    public String getMessage() {
        return message;
    }
}
