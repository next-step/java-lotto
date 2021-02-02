package lotto.domain;

import java.util.Map;
import java.util.Objects;

public class Price {

    private static final int ONE_LOTTO_PRICE = 1000;
    private static final int BASE_PRICE = 1000;
    private int money;

    public Price(String money) {
        isPriceValidate(money);
        this.money = Integer.parseInt(money);
    }

    public Price() {
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

    private boolean isPriceValidate(String price) throws IllegalArgumentException {
        Integer priceOrNull = Integer.parseInt(price);
        if (priceOrNull != 0 && priceOrNull % ONE_LOTTO_PRICE == 0) {
            return true;
        }
        throw new IllegalArgumentException();
    }

    public int calculateTotalPrize(Map<Revenue, Integer> revenueMap) {
        int totalRevenue = revenueMap.entrySet().stream()
            .mapToInt(
                entry -> entry.getKey()
                    .totalRevenue(
                        entry.getValue()
                    )
            )
            .sum();
        return totalRevenue;
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