package study.step3.domain;

public class Amount {
    private final static int MIN_AMOUNT = 1000;
    private final int amount;

    public Amount(int amount) {
        valid(amount);
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    private void valid(int amount) {
        if(amount < MIN_AMOUNT) {
            throw new IllegalArgumentException("유효하지 않는 금액입니다.");
        }
    }

    public int divide(int lottoPrice) {
        return this.amount / lottoPrice;
    }
}
