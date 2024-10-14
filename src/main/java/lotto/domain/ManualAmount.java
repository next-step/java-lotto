package lotto.domain;

public class ManualAmount {
    private final int value;

    public ManualAmount(int value) {
        this.value = value;
    }

    public int calculateAutoPurchaseQuantity(int total) {
        return total - value;
    }
}
