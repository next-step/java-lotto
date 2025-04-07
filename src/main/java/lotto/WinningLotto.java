package lotto;

public class WinningLotto {
    private Lotto winningLotto;
    private LottoNumber bonusNumber;

    public WinningLotto(Lotto winningLotto, LottoNumber bonusNumber) {
        if (winningLotto.isMatchedBonus(bonusNumber)) {
            throw new IllegalArgumentException("보너스 숫자는 로또가 가진 숫자와 겹칠 수 없습니다.");
        }
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public LottoRank getRank(Lotto lotto) {
        return LottoRank.valueOf(lotto.getMatchCount(winningLotto), lotto.isMatchedBonus(bonusNumber));
    }

}
