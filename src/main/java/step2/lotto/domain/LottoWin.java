package step2.lotto.domain;

import java.util.Set;

public class LottoWin {

    private final Lotto winLotto;

    public LottoWin(final Set<Integer> lottoWinNumbers) {
        this.winLotto = Lotto.of(lottoWinNumbers);
    }

    public Lotto getWinLotto() {
        return winLotto;
    }

    public int matchCount(final Lotto lotto) {
        return (int) winLotto.getLottoNumbers().stream()
            .filter(lottoNumber -> lotto.getLottoNumbers().contains(lottoNumber))
            .count();
    }
}
