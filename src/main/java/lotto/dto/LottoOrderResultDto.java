package lotto.dto;

import java.util.List;

public class LottoOrderResultDto {
    private final List<LottoOrderedDto> orderResult;
    private final int preOrderedLottoCount;

    public LottoOrderResultDto(List<LottoOrderedDto> orderResult, int preOrderedLottoCount) {
        this.orderResult = orderResult;
        this.preOrderedLottoCount = preOrderedLottoCount;
    }

    public List<LottoOrderedDto> getOrderResult() {
        return orderResult;
    }

    public int getPreOrderedLottoCount() {
        return preOrderedLottoCount;
    }
}
