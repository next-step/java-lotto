package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    public static final int LOTTO_NUM_SIZE = 6;
    private final List<LottoNum> lottoNums;

    public Lotto(List<Integer> nums) {
        validate(nums);
        this.lottoNums = nums.stream().map(LottoNum::new).collect(Collectors.toList());
        Collections.sort(this.lottoNums);
    }

    public List<Integer> getNums() {
        return lottoNums.stream().map(LottoNum::getNum).collect(Collectors.toList());
    }

    private void validate(List<Integer> nums) {
        if (nums.size() != LOTTO_NUM_SIZE) {
            throw new IllegalArgumentException("Lotto 숫자의 사이즈는 6개 입니다.");
        }
    }
}
