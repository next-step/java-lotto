package lotto.domain;

import java.util.List;

public class Lotto extends AbstractLotto {
    public Lotto(List<LottoNumber> lottoNumbers) {
        super(lottoNumbers);
    }

    public static Lotto from(List<LottoNumber> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    public List<LottoNumber> getNumbers() {
        return lottoNumbers;
    }
}
