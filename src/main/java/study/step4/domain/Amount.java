package study.step4.domain;

public class Amount {
    private static final int LOTTO_PRICE = 1000;
    private final int amount;

    public Amount(int amount) {
        valid(amount);
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    private void valid(int amount) {
        if ((amount < 0) || (amount % LOTTO_PRICE != 0)) {
            throw new IllegalArgumentException("로또 구매 최저 금액은 " + LOTTO_PRICE + "원 입니다.");
        }
    }

    public int getPurchaseLottoCount() {
        return this.amount / LOTTO_PRICE;
    }
}
