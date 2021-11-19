package lotto.step3.domain;

import java.util.Objects;

public class OrderCount {

    private static final int MIN_ORDER_COUNT = 1;
    private final int orderCount;

    public OrderCount(int orderCount) {
        if (orderCount < MIN_ORDER_COUNT) {
            throw new IllegalArgumentException("최소 주문은 1장 이상입니다.");
        }
        this.orderCount = orderCount;
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
