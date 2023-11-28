package step2.lotto.domain;

public class LottoPurchaseMoney {

    private final int purchaseMoney;

    private static final int LOTTO_PRICE = 1000;

    public LottoPurchaseMoney(final int inputMoney) {
        validateInputMoney(inputMoney);
        this.purchaseMoney = inputMoney;
    }

    public int getPurchaseMoney() {
        return purchaseMoney;
    }

    private void validateInputMoney(final int inputMoney) {
        if (inputMoney < LOTTO_PRICE) {
            throw new IllegalArgumentException("로또 구입 최소금액은 " + LOTTO_PRICE + "원 입니다.");
        }
    }
}
