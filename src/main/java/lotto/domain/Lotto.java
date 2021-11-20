package lotto.domain;

import java.util.Set;

public class Lotto {
    private final Set<LottoNumber> lottoNumbers;

    private Lotto(Set<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto from(NumberGenerator generator) {
        return new Lotto(generator.generate());
    }
}
