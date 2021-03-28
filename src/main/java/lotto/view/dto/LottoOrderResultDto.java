package lotto.view.dto;

import java.util.List;

public class LottoOrderResultDto {
    private final List<List<Integer>> orderedResult;

    public LottoOrderResultDto(List<List<Integer>> orderedResult) {
        this.orderedResult = orderedResult;
    }

    public List<List<Integer>> getOrderedResult() {
        return orderedResult;
    }
}
