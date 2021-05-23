package lotto.domain;

public class Money {

    public static final int LOTTO_PRICE = 1000;

    private final int amount;

    public Money(int amount) {
        validatePositive(amount);
        validateUnit(amount);
        this.amount = amount;
    }

    public static Money of(int amount) {
        return new Money(amount);
    }

    public int getBuyableLottoSize() {
        return amount / LOTTO_PRICE;
    }

    private void validatePositive(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("금액은 0보다 큰 정수를 입력해주세요.");
        }
    }

    private void validateUnit(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("금액은 1,000원 단위로 입력해주세요.");
        }
    }
}
