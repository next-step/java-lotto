package lotto.domain.value;

import java.util.Objects;

public class OrderPrice {

    private static final int LOTTO_PRICE = 1000;

    private final int orderPrice;

    private OrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }

    public static OrderPrice from(int orderPrice) {

        if (orderPrice < LOTTO_PRICE) {
            throw new IllegalArgumentException("1000원 이상 입력해주세요");
        }

        return new OrderPrice(orderPrice);
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderPrice that = (OrderPrice) o;
        return orderPrice == that.orderPrice;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderPrice);
    }
}
