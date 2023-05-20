package lotto.domain.lotto.dto;

import java.util.List;

public class LottoRequestDto {

    private final int purchaseMoney;
    private final int manualOrderCount;
    private final List<String> manualLottos;

    public LottoRequestDto(int purchaseMoney, int manualOrderCount, List<String> manualLottos) {
        this.purchaseMoney = purchaseMoney;
        this.manualOrderCount = manualOrderCount;
        this.manualLottos = manualLottos;
    }

    public int getPurchaseMoney() {
        return purchaseMoney;
    }

    public int getManualOrderCount() {
        return manualOrderCount;
    }

    public List<String> getManualLottos() {
        return manualLottos;
    }
}
