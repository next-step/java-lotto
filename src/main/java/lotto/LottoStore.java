package lotto;

public class LottoStore {

    private static final int LOTTO_PRICE = 1000;
    private static final int ZERO = 0;

    public static int sellLotto(int money) {
        validInputMoney(money);
        return money / LOTTO_PRICE;
    }

    private static void validInputMoney(int money) {
        if (money % LOTTO_PRICE != ZERO) {
            throw new IllegalArgumentException("입력값은 1000의 배수여야 합니다.");
        }
        if (money < ZERO) {
            throw new IllegalArgumentException("입력값은 양수여야 합니다.");
        }
    }


}
