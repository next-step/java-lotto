package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbers {

    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(final List<LottoNumber> lottoNumbers) {

        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNumber> getLottoNumbers() {

        return Collections.unmodifiableList(this.lottoNumbers);
    }

    public List<Integer> match(final WinningLottoNumber winningLottoNumber) {

        List<Integer> result = new ArrayList<>();
        for (LottoNumber lottoNumber : lottoNumbers) {
            result.add(lottoNumber.match(winningLottoNumber));
        }
        return result;
    }
}
