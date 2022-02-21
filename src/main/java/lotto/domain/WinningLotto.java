package lotto.domain;

import java.util.List;

public class WinningLotto {

    private final List<LottoNumber> winLotto;

    public WinningLotto(Lotto lotto) {
        this.winLotto = lotto.getLotto();
    }

    public static WinningLotto create(List<LottoNumber> lotto) {
        return new WinningLotto(new Lotto(lotto));
    }

    public List<LottoNumber> getWinLotto() {
        return winLotto;
    }
}
