package lotto.controller.dto;

import java.util.List;

public class WinInquiryRequest {

    private final List<LottoNumbersDto> purchaseNumbers;
    private final LottoNumbersDto winNumbers;
    private final int bonusNumber;

    public WinInquiryRequest(List<LottoNumbersDto> purchaseNumbers, LottoNumbersDto winNumbers, int bonusNumber) {
        this.purchaseNumbers = purchaseNumbers;
        this.winNumbers = winNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<LottoNumbersDto> getPurchaseNumbers() {
        return purchaseNumbers;
    }

    public LottoNumbersDto getWinNumbers() {
        return winNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
