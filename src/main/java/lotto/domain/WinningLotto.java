package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {

    private final Lotto winningLotto;
    private final LottoNumber bonusLottoNumber;

    public
    WinningLotto(Lotto winningLotto, LottoNumber bonusLottoNumber) {
        validWinningLotto(winningLotto);
        validBonusNumber(bonusLottoNumber);
        this.winningLotto = winningLotto;
        this.bonusLottoNumber = bonusLottoNumber;
    }

    private void validWinningLotto(Lotto winningLotto) {
        if (winningLotto == null) {
            throw new IllegalArgumentException("우승 번호가 제대로 입력되지 않음");
        }
    }

    private void validBonusNumber(LottoNumber bonusLottoNumber) {
        if (bonusLottoNumber == null) {
            throw new IllegalArgumentException("보너스 번호가 입력되지 않음");
        }
    }

    public List<LottoNumber> getWinningLotto() {
        return new ArrayList<>(winningLotto.getLotto());
    }

    public LottoNumber getBonusLottoNumber() {
        return bonusLottoNumber;
    }

}
