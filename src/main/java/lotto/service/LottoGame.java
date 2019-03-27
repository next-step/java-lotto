package lotto.service;

import lotto.*;
import lotto.generator.LottoGenerator;

public class LottoGame {
    private static LottoGame lottoGame = new LottoGame();

    private LottoGame() {
    }

    public static LottoGame getInstance() {
        return lottoGame;
    }

    public Lottos purchase(LottoGenerator lottoGenerator) {
        return lottoGenerator.generateLottos();
    }

    public LottosResult analyse(final Lottos purchasedLottos, final WinningLotto previousWinningLotto, final Money payment) {
        return new LottosResult(purchasedLottos, previousWinningLotto, payment);
    }
}
