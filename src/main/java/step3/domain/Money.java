package step3.domain;

public class Money {

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
        return amount / 1000;
    }

    private void validatePositive(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("금액은 0보다 큰 정수를 입력해주세요.");
        }
    }

    private void validateUnit(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("금액은 1,000원 단위로 입력해주세요.");
        }
    }
}
