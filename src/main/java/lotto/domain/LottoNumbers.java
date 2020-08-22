package lotto.domain;

import lotto.exception.LottoException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class LottoNumbers {

    public static final int LOTTO_START_NUMBER = 1;
    public static final int LOTTO_END_NUMBER = 45;

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
        for (int i = LOTTO_START_NUMBER; i <= LOTTO_END_NUMBER; i++) {
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
