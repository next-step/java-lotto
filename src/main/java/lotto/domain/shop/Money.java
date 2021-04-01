package lotto.domain.shop;

public class Money {
    private long balance;

    public Money(long money) {
        if (money < 0) {
            throw new IllegalArgumentException("금액은 음수일 수 없습니다.");
        }
        this.balance = money;
    }

    public boolean withdraw(long amount) {
        if (amount > balance) {
            return false;
        }
        this.balance -= amount;
        return true;
    }
}
