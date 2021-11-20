package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<LottoNumber> lottoNumbers;

    private Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto from(NumberGenerator generator) {
        return new Lotto(generator.generate());
    }

    public List<LottoNumber> getNumbers() {
        return lottoNumbers;
    }
}
