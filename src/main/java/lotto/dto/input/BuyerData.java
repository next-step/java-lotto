package lotto.dto.input;

public class BuyerData {

    private int purchaseAmount;

    public BuyerData(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public int purchaseAmount() {
        return purchaseAmount;
    }
}
