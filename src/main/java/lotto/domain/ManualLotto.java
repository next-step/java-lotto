package lotto.domain;

import java.util.List;

public class ManualLotto extends Lotto {

    public ManualLotto(List<LottoNumber> lottoNumbers) {
        super(lottoNumbers);
    }

    @Override
    public LottoType getLottoType() {
        return LottoType.MANUAL;
    }
}
