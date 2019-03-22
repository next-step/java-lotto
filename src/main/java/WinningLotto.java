import java.util.List;

public class WinningLotto {
    private Lotto lotto;
    private int bonusNumber;

    public WinningLotto(List<Integer> lotto, int bonusNumber) {
        this.lotto = new Lotto(lotto);
        this.bonusNumber = bonusNumber;
    }

    public boolean isMatchBonusNumber(List<Integer> lottoNumbers) {
        return lottoNumbers.contains(bonusNumber);
    }

    public int getMatchNumber(List<Integer> userLotto) {
        return lotto.getMatchNumber(userLotto);
    }
}
