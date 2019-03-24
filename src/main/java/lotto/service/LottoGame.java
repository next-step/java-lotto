package lotto.service;

import lotto.*;

import java.util.List;

public class LottoGame {
    private LottoGenerator lottoGenerator;

    private LottoGame(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public static LottoGame getInstance(LottoGenerator lottoGenerator) {
        return new LottoGame(lottoGenerator);
    }

    public PurchasedLottos purchase(final Money payment, final List<String> manualLottos) {
        return new PurchasedLottos(payment, manualLottos, lottoGenerator);
    }

    public LottosResult analyse(final PurchasedLottos purchaseHistory, final WinningLotto previousWinningLotto, final Money payment) {
        return new LottosResult(purchaseHistory, previousWinningLotto, payment);
    }
}
