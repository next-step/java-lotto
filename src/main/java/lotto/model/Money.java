package lotto.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Money {
    static final int TICKET_PRICE = 1_000;
    static final int MINIMUM_VALUE = 0;
    static final String OUT_OF_RANGE_MESSAGE = "Money는 0원 미만이 될 수 없습니다.";

    private static final Map<Integer, Money> CACHE = new HashMap<>();
    private int value;

    private Money(int value) {
        checkRange(value);
        this.value = value;
    }

    private void checkRange(int value) {
        if (value < MINIMUM_VALUE) {
            throw new IllegalArgumentException(OUT_OF_RANGE_MESSAGE);
        }
    }

    public static Money valueOf(int value) {
        Money money = CACHE.getOrDefault(value, new Money(value));
        CACHE.putIfAbsent(value, money);
        return money;
    }

    public int getNumberOfTicketForPurchase() {
        return value / TICKET_PRICE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Money)) return false;
        Money money = (Money) o;
        return value == money.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
