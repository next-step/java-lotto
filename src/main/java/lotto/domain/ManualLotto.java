package lotto.domain;

import java.util.List;

public class ManualLotto extends Lotto {

    public static ManualLotto create(List<LottoNumber> lottoNumbers) {
        return new ManualLotto(lottoNumbers);
    }

    public ManualLotto(List<LottoNumber> lottoNumbers) {
        super(lottoNumbers);
    }

    @Override
    public boolean isAuto() {
        return false;
    }
}
