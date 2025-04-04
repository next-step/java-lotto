package lotto;

public class PurchasePrice {

    private final int value;

    public PurchasePrice(String inputPrice) {
        this.value = Integer.parseInt(inputPrice);
    }

    public int getValue() {
        return value;
    }
}
