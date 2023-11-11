package lotto.ui.dto;

import lotto.domain.Lotto;

import java.util.List;

public class LottoResponse {

    private List<Integer> nums;

    public LottoResponse(List<Integer> nums) {
        this.nums = nums;
    }

    public static LottoResponse from(Lotto lotto) {
        return new LottoResponse(lotto.getNums());
    }

    public List<Integer> getNums() {
        return nums;
    }
}
