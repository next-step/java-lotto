package lotto.step3.domain;

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

}
