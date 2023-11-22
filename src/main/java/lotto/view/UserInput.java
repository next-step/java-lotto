package lotto.view;

public class UserInput {
    private final int purchasePrice;
    private final int manualLottoCount;

    public UserInput(int purchasePrice, int manualLottoCount) {
        this.purchasePrice = purchasePrice;
        this.manualLottoCount = manualLottoCount;
    }

    public int purchasePrice() {
        return purchasePrice;
    }

    public int manualLottoCount() {
        return manualLottoCount;
    }
}
