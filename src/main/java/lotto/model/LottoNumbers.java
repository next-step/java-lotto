package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbers {
    private List<List<Integer>> lottoNumbers = new ArrayList<>();

    public List<List<Integer>> getLottoNumbers(int gameCount) {
        LottoNumber lottoNumber = new LottoNumber();
        for (int count = 0; count < gameCount; count++) {
            lottoNumbers.add(lottoNumber.shuffle());
        }
        return lottoNumbers;
    }
}
