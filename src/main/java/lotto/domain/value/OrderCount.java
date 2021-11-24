package lotto.domain.value;

import java.util.Objects;

public class OrderCount {

    private static final int MIN_ORDER_COUNT = 1;

    private final int orderCount;

    public OrderCount(int orderCount) {
        this.orderCount = orderCount;
    }

    public static OrderCount from(int orderCount) {

        if (orderCount < MIN_ORDER_COUNT) {
            throw new IllegalArgumentException("로또 살수 있는 최소 금액은 1000원 입니다!!");
        }

        return new OrderCount(orderCount);
    }

    public int getOrderCount() {
        return orderCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderCount that = (OrderCount) o;
        return orderCount == that.orderCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderCount);
    }
}
