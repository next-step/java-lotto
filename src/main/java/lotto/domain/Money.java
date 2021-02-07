package lotto.domain;

import lotto.util.NumberUtils;

public class Money {

    private static final int BASE_PRICE = 1000;

    private final Integer money;

    public Money(String money) {
        validate(money);
        this.money = Integer.parseInt(money);
    }

    public int calculateTickets() {
        return money / BASE_PRICE;
    }

    private void validate(String price) throws IllegalArgumentException {
        Integer priceOrNull = NumberUtils.returnInteger(price);
        if (priceOrNull == null || priceOrNull <= 0) {
             throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return money.toString();
    }
}