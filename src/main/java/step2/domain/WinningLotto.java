package step2.domain;

import java.util.List;

public class WinningLotto extends Lotto {

    private LottoNumber bonusNumber;

    public WinningLotto(List<LottoNumber> lottoNumbers, LottoNumber bonusNumber) {
        super(lottoNumbers);
        this.bonusNumber = bonusNumber;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
