package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbers {
    private List<Integer> lottoNumbers;
    LottoNumbers() {
        lottoNumbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            lottoNumbers.add(i);
            Collections.shuffle(lottoNumbers);
        }
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
