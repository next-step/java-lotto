package lotto.ui.dto;

import lotto.domain.Lotto;
import lotto.domain.LottoNum;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoResponse {

    private final List<Integer> nums = new ArrayList<>();

    public LottoResponse(List<Integer> nums) {
        this.nums.addAll(nums);
    }

    public static LottoResponse from(Lotto lotto) {
        return new LottoResponse(lotto.getLottoNums().stream().map(LottoNum::getNum).collect(Collectors.toList()));
    }

    public List<Integer> getNums() {
        return nums;
    }
}
