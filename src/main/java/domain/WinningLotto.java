package domain;

import domain.wrapper.LottoNo;

public class WinningLotto {
    private LottoNo bonusNumber;
    private Lotto lotto;

    public WinningLotto(Lotto lotto, LottoNo bonusNumber) {
        this.lotto = lotto;
        isDuplication(lotto, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void isDuplication(Lotto lotto, LottoNo bonusNumber) {
        if(lotto.isContains(bonusNumber)){
            throw new RuntimeException("로또번호와 보너스번호는 겹칠 수 없습니다.");
        }
    }

    public LottoResult getCombineNumbers(Lotto lotto) {
        return new LottoResult(this.lotto.getCombineCount(lotto),  lotto.isContains(bonusNumber));
    }

    public int getCombineCount(Lotto lastLotto) {
        return lotto.getCombineCount(lastLotto);
    }
}
