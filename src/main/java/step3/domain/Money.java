package step3.domain;

public class Money {

    private final int amount;

    public Money(int amount) {
        validateUnit(amount);
        this.amount = amount;
    }

    private void validateUnit(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("금액은 1,000원 단위로 입력해주세요.");
        }
    }

    public static Money of(int amount) {
        return new Money(amount);
    }

    public int getBuyableLottoSize() {
        return amount / 1000;
    }
}
