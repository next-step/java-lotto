package lottery.domain;

public class ManualQuantity {

    private final int value;

    public ManualQuantity(int value) {
        this.value = value;
    }

    public boolean beyondTheAmount(int totalQuantities) {
        return this.value > totalQuantities;
    }

    public int autoPlays(int totalQuantities) {
        return totalQuantities - value;
    }

    public int manualPlays() {
        return this.value;
    }
}
