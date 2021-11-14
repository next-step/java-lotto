package lotto.step2.domain;

public class LotteryStore {

    private static final int LOTTO_PRICE = 1000;
    private Lotteries lotteries;
    private int orderCount;

    public LotteryStore() {}

    public LotteryStore(int orderPrice) {
        orderCount = orderPrice / LOTTO_PRICE;
        lotteries = new Lotteries(orderCount);
    }

    public int getOrderCount() {
        return orderCount;
    }

    public Lotteries getLotteries() {
        return lotteries;
    }


}
