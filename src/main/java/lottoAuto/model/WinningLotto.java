package lottoAuto.model;

import java.util.Collections;
import java.util.List;

public class WinningLotto {
    private Lotto winningLotto;
    private int bonusBall;

    public WinningLotto(Lotto winningLotto, int bonusBall) {
        this.winningLotto = winningLotto;
        this.bonusBall = bonusBall;
    }

    public List<LottoNumber> getWinningLotto() {
        return Collections.unmodifiableList(winningLotto.getLottoNumbers());
    }
}
