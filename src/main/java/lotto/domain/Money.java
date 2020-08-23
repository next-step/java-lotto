package lotto.domain;

import java.util.Objects;

public class Money {
    private static final String LESS_THAN_LOTTO_PRICE = "%d 보다 금액이 커야합니다.";

    private final int price;

    private Money(final int price) {
        validate(price);
        this.price = price;
    }

    public static Money of(final int price) {
        return new Money(price);
    }

    public int getPrice() {
        return price;
    }

    private void validate(final int price) {
        if (price < LottoStore.LOTTO_PRICE) {
            throw new IllegalArgumentException(String.format(LESS_THAN_LOTTO_PRICE, LottoStore.LOTTO_PRICE));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money that = (Money) o;
        return price == that.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
    }
}
