package lotto.domain;

public class WinningLotto {
    private Lotto winninglotto;
    private LottoNumber bonusNumber;

    public WinningLotto(Lotto wininglotto, LottoNumber bonusNumber){
        this.winninglotto = wininglotto;

        if (winninglotto.isContain(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호가 지난주 당첨번호와 중복됩니다.");
        }
        this.bonusNumber = bonusNumber;

    }

    public int getMatchCount(Lotto lotto) {
        return lotto.matchCount(winninglotto);
    }

    public boolean isContainBonusNumber(Lotto lotto) {
        return lotto.isContain(bonusNumber);
    }
}
