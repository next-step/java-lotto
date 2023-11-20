package step2.lotto.domain;

import java.util.Set;

public class LottoWinNumberInfo {

    private final Lotto winLotto;

    public LottoWinNumberInfo(final Set<Integer> lottoWinNumbers) {
        this.winLotto = new Lotto(lottoWinNumbers);
    }

    public Lotto getWinLotto() {
        return winLotto;
    }
}
