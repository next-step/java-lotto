package lotto.domain;

public class Money {
    private int balance;

    public Money(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("금액은 음수일 수 없습니다.");
        }
        this.balance = money;
    }

    public boolean withdraw(int amount) {
        if (amount > balance) {
            return false;
        }
        balance = balance - amount;
        return true;
    }
}
