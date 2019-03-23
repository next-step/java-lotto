import java.util.List;

public class WinningLotto {
    private Lotto lotto;
    private LottoNumber bonusNumber;

    public WinningLotto(List<LottoNumber> lotto, int bonusNumber) {
        this.lotto = new Lotto(lotto);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public int getMatchNumber(Lotto userLotto) {
        return userLotto.getMatchNumber(lotto);
    }

    public boolean isMatchBonusNumber(Lotto userLotto) {
        return userLotto.isMatchBonusNumber(bonusNumber);
    }
}
