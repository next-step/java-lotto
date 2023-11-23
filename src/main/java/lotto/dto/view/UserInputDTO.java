package lotto.dto.view;

public class UserInputDTO {
    private final int purchasePrice;
    private final int manualLottoCount;

    public UserInputDTO(int purchasePrice, int manualLottoCount) {
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
