package lotto.domain;

public class Money {
    private static final int LOTTO_PRICE = 1_000;
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

    public int getLottoCount() {
        return price / LOTTO_PRICE;
    }

    private void validate(final int price) {
        if (price < LOTTO_PRICE) {
            throw new IllegalArgumentException(String.format(LESS_THAN_LOTTO_PRICE, LOTTO_PRICE));
        }
    }
}
