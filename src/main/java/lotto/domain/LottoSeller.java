package lotto.domain;

public class LottoSeller {
    private final static int PRICE = 1000;

    public LottoSeller(int money) {
        checkMoney(money);
    }

    private static void checkMoney(int money) {
        if (money < PRICE) {
            throw new IllegalArgumentException("money is less than " + PRICE);
        }
    }
}
