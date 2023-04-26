package lotto.domain;

public class PurchasedAmount {

    private static final int LOTTO_PRICE = 1_000;

    private final int availableLottoCount;

    public PurchasedAmount(int amount) {
        validateAmount(amount);
        this.availableLottoCount = amount / LOTTO_PRICE;
    }

    private void validateAmount(int value) {
        if (value < LOTTO_PRICE) {
            throw new IllegalArgumentException(String.format("최소 구매입력은 %d원 이상입니다.", LOTTO_PRICE));
        }
    }

    public int getAvailableLottoCount() {
        return availableLottoCount;
    }

}