package lotto.domain;

import java.util.List;

public class AutoLotto extends Lotto {

    public static AutoLotto create(List<LottoNumber> lottoNumbers) {
        return new AutoLotto(lottoNumbers);
    }

    public AutoLotto(List<LottoNumber> lottoNumbers) {
        super(lottoNumbers);
    }

    @Override
    public boolean isAuto() {
        return true;
    }
}
