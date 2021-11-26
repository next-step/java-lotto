package lotto.step3.domain;

import java.util.List;
import java.util.Objects;

public class LottoStore {

    private static final int LOTTO_PRICE = 1000;

    private final OrderPrice orderPrice;

    public LottoStore(int orderPrice) {
        this.orderPrice = new OrderPrice(orderPrice);
    }

    public Lotteries sellAllLotteries(int orderManualCount, List<List<Integer>> lotteries) {
        return new Lotteries(lotteries, calculateAutoCount(orderManualCount));
    }

    public int calculateAutoCount(int orderManualCount) {
        OrderCount manualCount = new OrderCount(orderManualCount);
        return manualCount.calculateAutoCount(calculateAllCount());
    }

    public OrderCount calculateAllCount() {
        return new OrderCount(orderPrice.getOrderPrice() / LOTTO_PRICE);
    }

    public OrderPrice getOrderPrice() {
        return orderPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoStore that = (LottoStore) o;
        return Objects.equals(orderPrice, that.orderPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderPrice);
    }

    @Override
    public String toString() {
        return "LottoStore{" +
                "orderPrice=" + orderPrice +
                '}';
    }

}
