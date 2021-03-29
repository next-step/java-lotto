package lotto.view.dto;

import java.util.List;

public class LottoOrderResultDto {
    private final List<LottoDto> orderedResult;

    public LottoOrderResultDto(List<LottoDto> orderedResult) {
        this.orderedResult = orderedResult;
    }

    public List<LottoDto> getOrderedResult() {
        return orderedResult;
    }

}
