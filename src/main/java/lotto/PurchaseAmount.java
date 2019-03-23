package lotto;

public class PurchaseAmount {
    public static final int LOTTO_PRICE = 1_000;
    private final int lottoCnt;

    public PurchaseAmount(String money) {
        this(toInt(money));
    }

    public PurchaseAmount(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException();
        }
        lottoCnt = money / LOTTO_PRICE;
    }

    private static int toInt(String money) {
        return Integer.parseInt(money);
    }

    public int getLotto() {
        return lottoCnt;
    }
}
