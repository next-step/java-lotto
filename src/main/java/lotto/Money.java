package lotto;

public class Money {
    private final int amount;

    public Money(int amount) {
        if (amount < 0) throw new IllegalArgumentException("구입 금액은 음수일 수 없습니다.");
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
