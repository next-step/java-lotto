package lotto.domain;

import java.util.List;

public class WinningLotto {
    private Lotto winningLotto;
    private LottoNumber bonusNumber;

    public WinningLotto(String winningLottoString, int bonus) {
        List<LottoNumber> lottoNumbers = LottoBox.parseNumberString(winningLottoString);
        this.winningLotto = new Lotto(lottoNumbers);
        this.bonusNumber = new LottoNumber(bonus);
    }

    public LottoRank match(Lotto lotto) {
        return LottoRank.getRank(lotto.compare(winningLotto), lotto.contains(bonusNumber));
    }
}
