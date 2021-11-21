package lotto.step3.domain;

import java.util.Objects;

public class LottoStore {

    private final OrderPrice orderPrice;
    private final OrderCount orderCount;

    public LottoStore(int orderPrice) {
        this.orderPrice = new OrderPrice(orderPrice);
        this.orderCount = this.orderPrice.createOrderCount();
    }

    public Lotteries sellLotteries() {
        return new Lotteries(orderCount.getOrderCount());
    }

    public OrderPrice getOrderPrice() {
        return orderPrice;
    }

    public OrderCount getOrderCount() {
        return orderCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoStore that = (LottoStore) o;
        return Objects.equals(orderPrice, that.orderPrice) && Objects.equals(orderCount, that.orderCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderPrice, orderCount);
    }

    @Override
    public String toString() {
        return "LottoStore{" +
                "orderPrice=" + orderPrice +
                ", orderCount=" + orderCount +
                '}';
    }

}
