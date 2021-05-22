package lotto.controller.dto;

import java.util.List;

public class LottoPurchaseResponse {

    private final List<LottoNumbersDto> lottoNumbersDtoList;

    public LottoPurchaseResponse(List<LottoNumbersDto> lottoNumbersDtoList) {
        this.lottoNumbersDtoList = lottoNumbersDtoList;
    }

    public List<LottoNumbersDto> getLottoNumbersDtoList() {
        return lottoNumbersDtoList;
    }
}
