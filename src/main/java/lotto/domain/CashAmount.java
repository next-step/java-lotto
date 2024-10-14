package lotto.domain;

public class CashAmount {
    private final int value;

    public CashAmount(int value) {
        this.value = value;
    }

    public boolean isLessThan(int price) {
        return value < price;
    }

    public int calculatePurchaseQuantity(int price) {
        return value / price;
    }

    public double calculateProfitRate(int sum) {
        return (double) sum / value;
    }
}
