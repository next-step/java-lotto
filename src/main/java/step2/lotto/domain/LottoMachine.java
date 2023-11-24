package step2.lotto.domain;

import step2.lotto.domain.factory.LottosFactory;
import step2.lotto.strategy.LottoNumberGenerator;

public class LottoMachine {

    private final Lottos purchaseLottos;
    private final LottoPurchase lottoPurchase;

    public LottoMachine(final int inputMoney, final LottoNumberGenerator lottoNumberGenerator) {
        this.lottoPurchase = new LottoPurchase(inputMoney);
        this.purchaseLottos = new Lottos(
            LottosFactory.createLottos(lottoPurchase.getLottoTicketCount(), lottoNumberGenerator));
    }

    public LottoPurchase getLottoPurchaseInfo () {
        return lottoPurchase;
    }

    public Lottos getPurchaseLottos() {
        return purchaseLottos;
    }

    public LottoScore calculateLottoStatistics(final LottoWin winNumberInfo) {
        LottoScore lottoScore = LottoScore.create();
        lottoScore.recordMatchLotto(purchaseLottos, winNumberInfo);
        return lottoScore;
    }
}
