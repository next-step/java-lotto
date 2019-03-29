package lotto.service;

import lotto.domain.Lottos;
import lotto.domain.LottosResult;
import lotto.domain.WinningLotto;
import lotto.domain.generator.LottoGenerator;

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

    public LottosResult analyse(final Lottos purchasedLottos, final WinningLotto previousWinningLotto) {
        return new LottosResult(purchasedLottos, previousWinningLotto);
    }
}
