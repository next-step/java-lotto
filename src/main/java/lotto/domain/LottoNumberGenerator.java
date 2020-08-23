package lotto.domain;

import lotto.utils.LottoValidationUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.utils.CommonConstant.*;

public class LottoNumberGenerator {

    private List<Integer> lottoNumbers;

    public LottoNumberGenerator(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public LottoNumberGenerator() {
        this.lottoNumbers = IntStream.range(NUMBER_ONE, NUMBER_FORTY_SIX)
                                    .boxed()
                                    .collect(Collectors.toList());
        Collections.shuffle(lottoNumbers);
    }

    public void validateLottoRange(List<Integer> lottoNumbers) {
        for (int number : lottoNumbers) {
            LottoValidationUtils.lottoNumberRangeCheck(number);
        }
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers.stream()
                .distinct()
                .limit(NUMBER_SIX)
                .sorted()
                .collect(Collectors.toList());
    }

    public int size() {
        return lottoNumbers.size();
    }

}
