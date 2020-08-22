package lotto.domain;

import lotto.exception.LottoException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static lotto.utils.CommonConstant.*;

public class LottoNumbers {

    private List<Integer> lottoNumbers;

    public LottoNumbers(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public LottoNumbers() {
        this.lottoNumbers = new ArrayList<>();
        this.lottoNumbers = initLottoNumbers(lottoNumbers);
        this.lottoNumbers = shuffleLottoNumber(lottoNumbers);
    }

    private List<Integer> initLottoNumbers(List<Integer> lottoNumbers) {
        for (int i = NUMBER_ONE; i <= NUMBER_FORTY_FIVE; i++) {
            lottoNumbers.add(i);
        }
        return lottoNumbers;
    }

    private List<Integer> shuffleLottoNumber(List<Integer> lottoNumbers) {
        Collections.shuffle(lottoNumbers);
        return lottoNumbers;
    }

    public void lottoNumberRangeException(LottoNumbers lottoNumbers) {
        for (int number : lottoNumbers.lottoNumbers) {
            LottoException.lottoNumberRangeCheck(number);
        }
    }

    public Stream<Integer> getLottoNumbers() {
        return lottoNumbers.stream();
    }

    public long count() {
        return lottoNumbers.stream()
                .count();
    }

}
