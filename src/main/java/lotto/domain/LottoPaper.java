package lotto.domain;

import java.util.List;

public class LottoPaper {
    private final List<Integer> lottoNumbers;

    public LottoPaper(List<Integer> numberList) {
        lottoNumbers = numberList;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
