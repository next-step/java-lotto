package lotto.controller.dto;

import java.util.List;

public class WinInquiryRequest {

    private final List<LottoNumbersDto> purchaseNumbers;
    private final LottoNumbersDto winNumbers;

    public WinInquiryRequest(List<LottoNumbersDto> purchaseNumbers, LottoNumbersDto winNumbers) {
        this.purchaseNumbers = purchaseNumbers;
        this.winNumbers = winNumbers;
    }

    public List<LottoNumbersDto> getPurchaseNumbers() {
        return purchaseNumbers;
    }

    public LottoNumbersDto getWinNumbers() {
        return winNumbers;
    }
}
