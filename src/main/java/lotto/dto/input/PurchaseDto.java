package lotto.dto.input;

import java.util.List;

public class PurchaseDto {
    private final int purchaseMoney;
    private final int numOfManualLottos;
    private final List<String> manualLottos;

    public PurchaseDto(int purchaseMoney, int numOfManualLottos, List<String> manualLottos) {
        this.purchaseMoney = purchaseMoney;
        this.numOfManualLottos = numOfManualLottos;
        this.manualLottos = manualLottos;
    }

    public int getPurchaseMoney() {
        return purchaseMoney;
    }

    public int getNumOfManualLottos() {
        return numOfManualLottos;
    }

    public List<String> getManualLottos() {
        return manualLottos;
    }
}
