package lotto.model;

public class Counter {
    private final int quantity;
    private int autoQuantity;
    private int manualQuantity;

    public Counter(int quantity) {
        this.quantity = quantity;
    }

    public void calculateAutoQuantity(int manualQuantity) {
        this.manualQuantity = manualQuantity;
        this.autoQuantity = quantity - manualQuantity;
    }

    public int getAutoQuantity() {
        return autoQuantity;
    }

    public int getManualQuantity() {
        return manualQuantity;
    }
}
