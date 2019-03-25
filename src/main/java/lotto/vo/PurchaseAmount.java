package lotto.vo;

public class PurchaseAmount {
    public static final int LOTTERY_PRICE = 1_000;
    private final int lotteryTickets;
    private final int money;

    public PurchaseAmount(String money) {
        this(toInt(money));
    }

    public PurchaseAmount(int money) {
        if (money < LOTTERY_PRICE) {
            throw new IllegalArgumentException();
        }
        lotteryTickets = money / LOTTERY_PRICE;
        this.money = money;
    }

    private static int toInt(String money) {
        return Integer.parseInt(money);
    }

    public int getLotto() {
        return lotteryTickets;
    }

    public double yield(PurchaseAmount revenue) {
        return (double)((revenue.money * 100) / money)/100;
    }
}
