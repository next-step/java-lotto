package step2.domain.lotto;

import step2.domain.statistics.Amount;

import java.util.Objects;

public class Price {
    private static final int LOTTO_PRICE = 1000;

    private final int price;

    public Price(int price) {

        if (price <= LOTTO_PRICE) {
            throw new RuntimeException(String.format("구매 금액은 로또 가격(%d) 이하일 수 없습니다.", LOTTO_PRICE));
        }
        this.price = price;
    }

    public Amount amount() {
        return new Amount(this.price / LOTTO_PRICE);
    }

    public Amount spend(Amount manualAmount) {
        return new Amount(this.amount().minus(manualAmount));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Price)) return false;
        Price price1 = (Price) o;
        return price == price1.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
    }
}
