package lotto.model.service;

import lotto.model.domain.*;

import java.util.List;

public final class LottoGame {

    private Lottos lottos;
    private WinningLotto winningLotto;

    public void buyLottos(final List<List<Integer>> manualLottos, final LottosSize lottosSize) {
        this.lottos = Lottos.create(manualLottos, lottosSize.getAutomaticSize());
    }

    public void winningLotto(final List<Integer> winningNumbers, final int bonusBall) {
        this.winningLotto = WinningLotto.of(
                Lotto.create(winningNumbers),
                LottoNumber.of(bonusBall)
        );
    }

    public LottoResult result(LottoMoney purchase) {
        final Ranks ranks = Ranks.of(lottos.matchWinningNumbers(winningLotto));
        return LottoResult.of(ranks, purchase);
    }

    public Lottos getLottos() {
        return lottos;
    }
}
