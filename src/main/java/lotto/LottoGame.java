package lotto;

public class LottoGame {
    public static final int LOTTO_PRICE = 1000;

    private int count;

    public LottoGame(int money) {
        validateMoney(money);
        count = money / LOTTO_PRICE;
    }

    private static void validateMoney(int money) {
        if (money < 1000) {
            throw new IllegalArgumentException("로또 구입 금액은 1000원을 넘어야 합니다.");
        }
    }
}
