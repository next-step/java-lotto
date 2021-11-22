package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto extends AbstractLotto {
    private Lotto(List<LottoNumber> lottoNumbers) {
        super(lottoNumbers);
    }

    public static Lotto from(List<LottoNumber> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    public List<LottoNumber> getNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    public boolean contain(LottoNumber number) {
        return lottoNumbers.contains(number);
    }
}
