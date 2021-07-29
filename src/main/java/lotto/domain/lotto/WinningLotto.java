package lotto.domain.lotto;

import lotto.domain.lotto.number.LottoNumber;

import java.util.List;

public class WinningLotto extends BaseLotto {

    private WinningLotto(List<LottoNumber> lottoNumbers) {
        super(lottoNumbers);
    }

    public static WinningLotto of(List<LottoNumber> lottoNumbers) {
        return new WinningLotto(lottoNumbers);
    }
}
