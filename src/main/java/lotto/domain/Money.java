package lotto.domain;

public class Money {

    public static final int LOTTO_PRICE = 1000;

    private final int purchasePrice;

    private Money(int purchasePrice) {
        validationCheck(purchasePrice);
        this.purchasePrice = purchasePrice;
    }

    private void validationCheck(int purchasePrice) {
        if (purchasePrice < LOTTO_PRICE) {
            throw new IllegalArgumentException("구입금액은 최소 1000원 이상입니다.");
        }
    }

    public static Money of(int purchasePrice) {
        return new Money(purchasePrice);
    }

    public int getTotalPurchaseSize() {
        return purchasePrice / LOTTO_PRICE;
    }

    public double calculateReturnRate(int winningPrice) {
        return Math.round(((double) winningPrice / purchasePrice) * 100) / 100.0;
    }
}
