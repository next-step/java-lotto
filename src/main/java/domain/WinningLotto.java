package domain;

public class WinningLotto {

    private LottoSet winningLotto;
    private LottoNumber bonusNumber;

    public WinningLotto(LottoSet winningLotto, LottoNumber bonusNumber) {
        if(winningLotto.isMatchNumber(bonusNumber)) {
            throw new IllegalArgumentException("당첨번호와 보너스번호 중복입니다.");
        }

        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public int getMatchNumber(LottoSet lottoSet) {
        return lottoSet.countOfMatchNumber(winningLotto);
    }

    public boolean isMatchBonusNumber(LottoSet lottoSet) {
        return lottoSet.isMatchNumber(bonusNumber);
    }

}