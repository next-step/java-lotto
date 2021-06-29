package lottoAuto.model;

import java.util.Collections;
import java.util.Set;

public class WinningLotto {
    private Lotto winningLotto;
    private int bonusBall;

    public WinningLotto(Lotto winningLotto, int bonusBall) {
        this.winningLotto = winningLotto;
        this.bonusBall = bonusBall;
    }

    public Set<LottoNumber> getWinningLotto() {
        return Collections.unmodifiableSet(winningLotto.getLottoNumbers());
    }

    public int getBonusBall() {
        return bonusBall;
    }
}
