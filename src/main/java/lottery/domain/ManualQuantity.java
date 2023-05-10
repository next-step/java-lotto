package lottery.domain;

public class ManualQuantity {

    private final int value;

    public ManualQuantity(int value) {
        this.value = value;
    }

    public boolean beyondTheAmount(int totalQuantities) {
        return this.value > totalQuantities;
    }

}
