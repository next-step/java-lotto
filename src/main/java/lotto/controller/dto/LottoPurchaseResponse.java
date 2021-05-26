package lotto.controller.dto;

import java.util.List;

public class LottoPurchaseResponse {

    private final int manualTicketCount;
    private final int autoTicketCount;
    private final List<LottoNumbersDto> lottoNumbersDtoList;

    public LottoPurchaseResponse(int manualTicketCount, int autoTicketCount, List<LottoNumbersDto> lottoNumbersDtoList) {
        this.manualTicketCount = manualTicketCount;
        this.autoTicketCount = autoTicketCount;
        this.lottoNumbersDtoList = lottoNumbersDtoList;
    }

    public int getManualTicketCount() {
        return manualTicketCount;
    }

    public int getAutoTicketCount() {
        return autoTicketCount;
    }

    public List<LottoNumbersDto> getLottoNumbersDtoList() {
        return lottoNumbersDtoList;
    }
}
