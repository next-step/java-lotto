package study.step3.domain;

public class Amount {
    private final int amount;

    public Amount(int amount) {
        valid(amount);
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    private void valid(int amount) {
        if(amount < 0) {
            throw new IllegalArgumentException("유효하지 않는 금액입니다.");
        }
    }
}
