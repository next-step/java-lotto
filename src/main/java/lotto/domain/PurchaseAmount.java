package lotto.domain;

public class PurchaseAmount {
    private static final int LOTTO_PRICE = 1000;

    private final Money money;

    public PurchaseAmount(int moneyValue) {
        this(new Money(moneyValue));
    }

    public PurchaseAmount(Money money) {
        validate(money.getValue());
        this.money = money;
    }

    private void validate(int moneyValue) {
        if (moneyValue % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("구입 금액은 1000원 단위여야 합니다.");
        }
    }

    public int getAmount() {
        return money.getValue();
    }

    public int getLottoCount() {
        return getAmount() / LOTTO_PRICE;
    }

    public double calculateProfitRate(int totalWinningAmount) {
        return money.calculateRate(totalWinningAmount);
    }

}
