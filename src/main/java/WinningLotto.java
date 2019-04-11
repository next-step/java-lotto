import java.util.List;

public class WinningLotto {
    private Lotto lotto;
    private LottoNumber bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public int getMatchNumber(Lotto userLotto) {
        return userLotto.getMatchNumber(lotto);
    }

    public boolean isMatchBonusNumber(Lotto userLotto) {
        return userLotto.isMatchBonusNumber(bonusNumber);
    }
}
