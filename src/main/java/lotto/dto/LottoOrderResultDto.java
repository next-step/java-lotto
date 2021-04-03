package lotto.dto;

import java.util.List;

public class LottoOrderResultDto {
    private final List<LottoOrderedDto> orderResult;

    public LottoOrderResultDto(List<LottoOrderedDto> orderResult) {
        this.orderResult = orderResult;
    }

    public List<LottoOrderedDto> getOrderResult() {
        return orderResult;
    }
}
