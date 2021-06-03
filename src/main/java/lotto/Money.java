package lotto;

public class Money {
    private int money;

    public Money(int num) {
        validateMoney(num);
        this.money = num;
    }

    public int value() {
        return this.money;
    }

    private void validateMoney(int num) {
        if (num <= 0) {
            throw new RuntimeException("구매 급액은 0보다 커야합니다.");
        }
    }
}
