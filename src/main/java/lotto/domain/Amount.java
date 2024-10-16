package lotto.domain;

public class Amount {
    private final int value;

    public Amount(int value) {
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

    public int calculateAutoPurchaseQuantity(int total) {
        return total - value;
    }
}
