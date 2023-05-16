package lotto.domain;

import java.util.Collections;
import java.util.Set;

public class WinnerNumbers {

    private final Set<LottoNumber> numbers;

    public WinnerNumbers(String lottoNumbers) {
        this(LottoNumbersParser.parseToSet(lottoNumbers));
    }

    public WinnerNumbers(Set<LottoNumber> lottoNumbers) {
        LottoValidator.validLottoNumbers(lottoNumbers);
        this.numbers = Collections.unmodifiableSet(lottoNumbers);
    }

    public int matchCount(Lotto lotto) {
        return (int) numbers.stream().filter(lotto::hasNumber).count();
    }
}
