package lottoauto.domain;

import java.util.List;

public class WinningLotto {
    private Lotto winnerLotto;
    private int bonusNumber;

    public WinningLotto(Lotto winnerLotto, int bonusNumber) {
        this.winnerLotto = winnerLotto;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinnerLottoNumbers() {
        return winnerLotto.getNumbers();
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
