package lotto;

public class Money {
    private int value;

    public Money(int num) {
        validateMoney(num);
        this.value = num;
    }

    public int value() {
        return this.value;
    }

    private void validateMoney(int num) {
        if (num <= 0) {
            throw new RuntimeException("구매 급액은 0보다 커야합니다.");
        }
    }
}
