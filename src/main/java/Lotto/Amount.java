package Lotto;

public class Amount {

    private int amount;

    public Amount(int amount) {
        if (amount < 0) {
            throw new RuntimeException("입력값은 음수가 될 수 없습니다.");
        }
        this.amount = amount;
    }

    public int getAmount() {
        return this.amount;
    }
}
