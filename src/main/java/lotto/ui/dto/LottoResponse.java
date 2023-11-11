package lotto.ui.dto;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoResponse {

    private final List<Integer> nums = new ArrayList<>();

    public LottoResponse(List<Integer> nums) {
        this.nums.addAll(nums);
    }

    public static LottoResponse from(Lotto lotto) {
        return new LottoResponse(lotto.getNums());
    }

    public List<Integer> getNums() {
        return nums;
    }
}
