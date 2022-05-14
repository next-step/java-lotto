package domain;

public class Cash {
    private final int cashAmount;

    public Cash(int cashAmount) {
        this.cashAmount = cashAmount;
    }

    public int capableLottoCount(int lottoPrice) {
        return cashAmount / lottoPrice;
    }

    public boolean isLessThan(int comparedNumber) {
        return cashAmount < comparedNumber;
    }

    public boolean isMultipleOf(int price) {
        return cashAmount % price == 0;
    }

    @Override
    public String toString() {
        return String.valueOf(cashAmount);
    }
}
