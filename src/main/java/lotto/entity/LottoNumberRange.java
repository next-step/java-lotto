package lotto.entity;


import java.util.ArrayList;
import java.util.List;

public class LottoNumberRange {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private final List<Integer> lottoNumbers = new ArrayList<>();

    public LottoNumberRange() {
        initNumber();
    }

    private void initNumber() {
        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            lottoNumbers.add(i);
        }
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public static void validateRange(Integer numbers) {
        if (numbers < MIN_LOTTO_NUMBER || MAX_LOTTO_NUMBER < numbers) {
            throw new IllegalArgumentException("1 ~ 45 사이의 값을 입력해 주세요");
        }
    }
}
