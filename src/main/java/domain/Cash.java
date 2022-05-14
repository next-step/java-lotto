package domain;

public class Cash {
    private final int cashAmount;

    public Cash(int cashAmount) {
        this.cashAmount = cashAmount;
    }

    public int capableLottoCount(int lottoPrice) {
        return cashAmount / lottoPrice;
    }
}
