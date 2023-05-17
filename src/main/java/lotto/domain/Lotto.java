package lotto.domain;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private final Set<LottoNumber> numbers;

    Lotto(String lottoNumbers) {
        this(LottoNumbersParser.parseToSet(lottoNumbers));
    }

    Lotto(List<LottoNumber> lottoNumbers) {
        this(new LinkedHashSet<>(lottoNumbers));
    }

    public Lotto(Set<LottoNumber> lottoNumbers) {
        LottoValidator.validLottoNumbers(lottoNumbers);
        this.numbers = Collections.unmodifiableSet(lottoNumbers);
    }

    public boolean hasNumber(LottoNumber number) {
        return this.numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
