package study.lotto.step2.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class LottoNumbers {
    private static final int NUMBER_OF_SELECT = 6;
    private final Set<LottoNumber> lottoNumbers;

    public LottoNumbers(Integer... lottoNumbers) {
        this(of(lottoNumbers));
    }

    public LottoNumbers(Set<LottoNumber> lottoNumbers) {
        validateLottoNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public Set<Integer> numbers() {
        return lottoNumbers.stream()
                .map(LottoNumber::number)
                .collect(Collectors.collectingAndThen(Collectors.toCollection(TreeSet::new), Collections::unmodifiableSet));
    }

    private void validateLottoNumbers(Set<LottoNumber> lottoNumbers) {
        if(lottoNumbers.size() != NUMBER_OF_SELECT) {
            throw new IllegalArgumentException("로또 번호 선택 갯수는 " + NUMBER_OF_SELECT + "개입니다: " + lottoNumbers.size());
        }
    }

    private static Set<LottoNumber> of(Integer... lottoNumbers) {
        return Arrays.stream(lottoNumbers)
                .map(LottoNumber::of)
                .collect(Collectors.toUnmodifiableSet());
    }
}
