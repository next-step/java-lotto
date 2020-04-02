package lotto.model.winninglotto;

import lotto.model.lottonumber.LottoNumber;
import lotto.model.lottonumber.LottoNumbers;

public class WinningLotto {
    private LottoNumbers winningLottoNumbers;
    private BonusBall bonusBall;

    public WinningLotto(LottoNumbers winningLottoNumbers) {
        this.winningLottoNumbers = winningLottoNumbers;
    }

    public WinningLotto(LottoNumbers winningLottoNumbers, BonusBall bonusBall) {
        this.winningLottoNumbers = winningLottoNumbers;
        this.bonusBall = bonusBall;
    }

    public boolean contains(LottoNumber lottoNumber) {
        return winningLottoNumbers
                .contains(lottoNumber);
    }

    public BonusBall getBonusNumber() {
        return bonusBall;
    }

    public static WinningLotto of(LottoNumbers winningLottoNumbers) {
        return new WinningLotto(winningLottoNumbers);
    }

    public static WinningLotto of(LottoNumbers winningLottoNumbers, BonusBall bonusBall) {
        return new WinningLotto(winningLottoNumbers, bonusBall);
    }
}