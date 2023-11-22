package lottosecond.domain;

public class Money {

    public static final int EACH_LOTTO_PRICE = 1000;

    private final int money;

    public Money(int money) {
        if (!isValidBuyPrice(money)) {
            throw new IllegalArgumentException("로또 구매 금액은 1000의 배수여야 합니다.");
        }

        this.money = money;
    }

    public int countLotto() {
        return money / EACH_LOTTO_PRICE;
    }

    private boolean isValidBuyPrice(int lottoBuyMoney) {
        return lottoBuyMoney % EACH_LOTTO_PRICE == 0;
    }
}
