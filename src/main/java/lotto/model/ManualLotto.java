package lotto.model;

public class ManualLotto {
    private final int manualQuantity;

    public ManualLotto(int manualQuantity, Price price) {
        validation(manualQuantity, price);
        this.manualQuantity = manualQuantity;
    }

    private void validation(int manualQuantity, Price price) {
        price.manualValidation(manualQuantity);
    }

    public int getManualQuantity() {
        return manualQuantity;
    }

    public int rest(Price price) {
        return price.restPrice(manualQuantity);
    }
}
