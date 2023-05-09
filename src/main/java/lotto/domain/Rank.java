package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, new Money(2_000_000_000L), "6개 일치 (2000000000원)- %d개"),
    SECOND(5, new Money(30_000_000L), "5개 일치, 보너스 볼 일치(30000000원)- %d개"),
    THIRD(5, new Money(1_500_000L), "5개 일치 (1500000원)- %d개"),
    FOURTH(4, new Money(50_000L), "4개 일치 (50000원)- %d개"),
    FIFTH(3, new Money(5_000L), "3개 일치 (5000원)- %d개"),
    MISS(0, new Money(0L), "");

    private final int count;
    private final Money money;
    private final String message;

    Rank(int count, Money money, String message) {
        this.count = count;
        this.money = money;
        this.message = message;
    }

    public static Rank of(long count, boolean hasBonus) {
        if (count == 5 && hasBonus) {
            return SECOND;
        }
        if (count == 5) {
            return THIRD;
        }
        return Arrays.stream(values())
                .filter(match -> match.count == count)
                .findAny()
                .orElse(MISS);
    }

    public Money getMoney() {
        return money;
    }

    public String getMessage() {
        return message;
    }
}
