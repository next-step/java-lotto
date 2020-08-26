package lotto.domain;

import java.util.List;

public class LottoNumber {
    private final List<Integer> nums;

    public LottoNumber(List<Integer> numberList) {
        nums = numberList;
    }

    public List<Integer> getNums() {
        return nums;
    }
}
