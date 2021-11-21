package lotto.step3.domain;

import java.util.Objects;

public class OrderPrice {

    private static final int LOTTO_PRICE = 1000;

    private final int orderPrice;

    public OrderPrice(int orderPrice) {
        if (orderPrice < LOTTO_PRICE) {
            throw new IllegalArgumentException("1000원 이상 입력해주세요");
        }
        this.orderPrice = orderPrice;
    }

    public OrderCount createOrderCount() {
        return new OrderCount(orderPrice / LOTTO_PRICE);
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

    @Override
    public String toString() {
        return "OrderPrice{" +
                "orderPrice=" + orderPrice +
                '}';
    }

}
