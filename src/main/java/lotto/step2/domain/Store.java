package lotto.step2.domain;

public class Store {

    private static final int LOTTO_PRICE = 1000;

    private final int orderPrice;
    private final int orderCount;
    private final Lotteries lotteries;

    public Store(int orderPrice) {
        checkOrderPrice(orderPrice);
        this.orderPrice = orderPrice;
        this.orderCount = this.orderPrice / LOTTO_PRICE;
        this.lotteries = new Lotteries(orderCount);
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public int getOrderCount() {
        return orderCount;
    }

    public Lotteries getLotteries() {
        return lotteries;
    }

    private static void checkOrderPrice(int orderPrice) {
        if (orderPrice < LOTTO_PRICE) {
            throw new IllegalArgumentException("1장 이상 가격 입력해주세요");
        }
    }

}
