package lotto.step3.domain;

import java.util.Objects;

public class OrderCount {

    private static final int MIN_ORDER_COUNT = 0;

    private final int orderCount;

    public OrderCount(int orderCount) {
        if (orderCount < MIN_ORDER_COUNT) {
            throw new IllegalArgumentException("주문 수량은 금액과 맞지 않습니다.");
        }
        this.orderCount = orderCount;
    }

    public int calculateAutoCount(OrderCount calculateAllCount) {
        return calculateAllCount.getOrderCount() - this.orderCount;
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

    @Override
    public String toString() {
        return "OrderCount{" +
                "orderCount=" + orderCount +
                '}';
    }

}
