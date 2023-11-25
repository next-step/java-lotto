package lotto;

import java.util.List;

public class WinningLottoNumbers {
    private Lotto winningLotto;
    private LottoNumber bonusBall;

    public WinningLottoNumbers(Lotto winningLotto, LottoNumber bonusBall) {
        this.winningLotto = winningLotto;
        this.bonusBall = bonusBall;
    }

    public WinningLottoNumbers(List<Integer> winningLotto, Integer bonusBall) {
        this.winningLotto = new Lotto(winningLotto);
        this.bonusBall = new LottoNumber(bonusBall);
    }

    public int countMatchingWinningLotto(Lotto lotto) {
        return winningLotto.countMatchingWinningLotto(lotto);
    }

    public boolean matchBonusBall(Lotto lotto) {
        return lotto.matchLottoNumber(bonusBall);
    }

}
