package step2.lotto.domain;

import step2.lotto.domain.factory.LottosFactory;
import step2.lotto.strategy.LottoNumberGenerator;

public class LottoMachine {

    private final Lottos purchaseLottos;
    private final LottoPurchaseInfo lottoPurchaseInfo;
    private final LottoScore lottoScore;

    public LottoMachine(final int inputMoney, final LottoNumberGenerator lottoNumberGenerator) {
        this.lottoPurchaseInfo = new LottoPurchaseInfo(inputMoney);
        this.purchaseLottos = new Lottos(
            LottosFactory.createLottos(lottoPurchaseInfo.getLottoTicketCount(), lottoNumberGenerator));
        this.lottoScore = new LottoScore();
    }

    public LottoPurchaseInfo getLottoPurchaseInfo () {
        return lottoPurchaseInfo;
    }

    public Lottos getPurchaseLottos() {
        return purchaseLottos;
    }

    public LottoScore getLottoScore() {
        return lottoScore;
    }

    public void calculateLottoStatistics(final LottoWinNumberInfo winNumberInfo) {
        lottoScore.recordMatchLotto(purchaseLottos, winNumberInfo);
    }
}
