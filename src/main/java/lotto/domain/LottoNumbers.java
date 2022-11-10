package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {

    private static final int START = 1;
    private static final int END = 45;

    private LottoNumbers() {
    }

    public static List<LottoNumber> getLottoNumbers() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = START; i < END; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }
        return lottoNumbers;
    }
}
