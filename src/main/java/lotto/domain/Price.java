package lotto.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Price {

    private static final int ONE_LOTTO_PRICE = 1000;
    private static final int BASE_PRICE = 1000;
    private final int money;

    public Price(String money) {
        isPriceValidate(money);
        this.money = Integer.parseInt(money);
    }

    public Price(int money) {
        this.money = money;
    }

    public Price getPrice() {
        return new Price(money);
    }

    public int calculateTicketCount() {
        return money / BASE_PRICE;
    }

    private void isPriceValidate(String price) throws IllegalArgumentException {
        int priceOrNull = Integer.parseInt(price);
        if (priceOrNull == 0 || priceOrNull % ONE_LOTTO_PRICE != 0) {
            throw new IllegalArgumentException();
        }
    }

    public Double calculateYield(int income) {
        BigDecimal bd = new BigDecimal((double) income / money);
        return bd
            .setScale(2, BigDecimal.ROUND_FLOOR)
            .doubleValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Price price = (Price) o;
        return money == price.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}