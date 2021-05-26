package lotto.controller.dto;

import java.util.List;

public class LottoPurchaseRequest {

    private final int purchaseAmount;
    private final int manualLottoTicketCount;
    private final List<LottoNumbersDto> manualLottoNumbers;

    public LottoPurchaseRequest(int purchaseAmount, int manualLottoTicketCount, List<LottoNumbersDto> manualLottoNumbers) {
        this.purchaseAmount = purchaseAmount;
        this.manualLottoTicketCount = manualLottoTicketCount;
        this.manualLottoNumbers = manualLottoNumbers;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public int getManualLottoTicketCount() {
        return manualLottoTicketCount;
    }

    public List<LottoNumbersDto> getManualLottoNumbers() {
        return manualLottoNumbers;
    }
}
