package lotto;

public class LottoMoney {

    private static final int LOTTO_PRICE = 1_000;

    public static int buy(int money) {
        checkMinimumAmount(money);
        return money / LOTTO_PRICE;
    }

    private static void checkMinimumAmount(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException();
        }
    }
}
