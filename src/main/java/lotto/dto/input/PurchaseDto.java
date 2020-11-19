package lotto.dto.input;

import java.util.List;

public class PurchaseDto {
    private final int purchaseMoney;
    private final List<String> manualLottos;

    public PurchaseDto(int purchaseMoney, List<String> manualLottos) {
        this.purchaseMoney = purchaseMoney;
        this.manualLottos = manualLottos;
    }

    public int getPurchaseMoney() {
        return purchaseMoney;
    }

    public List<String> getManualLottos() {
        return manualLottos;
    }
}
