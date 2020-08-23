package lotto.domain;

import lotto.exception.LottoException;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.utils.CommonConstant.NUMBER_FORTY_FIVE;
import static lotto.utils.CommonConstant.NUMBER_ONE;

public class LottoNumberGenerator {

    private List<Integer> lottoNumbers;

    public LottoNumberGenerator(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public LottoNumberGenerator() {
        this.lottoNumbers = IntStream.range(NUMBER_ONE, NUMBER_FORTY_FIVE).boxed().collect(Collectors.toList());
        Collections.shuffle(lottoNumbers);
    }

    public void lottoNumberRangeException(LottoNumberGenerator lottoNumberGenerator) {
        for (int number : lottoNumberGenerator.lottoNumbers) {
            LottoException.lottoNumberRangeCheck(number);
        }
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public long count() {
        return lottoNumbers.stream()
                .count();
    }

}
