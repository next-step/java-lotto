package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {

    private final List<Integer> lottoNumbers;

    public LottoNumbers(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getValue() {
        return new ArrayList<>(lottoNumbers);
    }
}
