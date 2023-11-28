package step2.lotto.domain;

import java.util.List;

public class LottoMachine {

    private final Lottos userPurchaseLottos;
    private final LottoPurchase lottoPurchase;

    public LottoMachine(final LottoPurchase lottoPurchase) {
        this.lottoPurchase = lottoPurchase;
        this.userPurchaseLottos = userPurchaseLottos(lottoPurchase);
    }

    public LottoMachine(final LottoPurchase lottoPurchase, final List<String> inputManualNumbers) {
        this.lottoPurchase = lottoPurchase;
        this.userPurchaseLottos = userPurchaseLottos(lottoPurchase);
    }

    public LottoPurchase getLottoPurchase() {
        return lottoPurchase;
    }

    public Lottos getUserPurchaseLottos() {
        return userPurchaseLottos;
    }

    public LottoScore calculateLottoStatistics(final LottoWin winNumberInfo) {
        LottoScore lottoScore = LottoScore.create();
        lottoScore.recordMatchLotto(userPurchaseLottos, winNumberInfo);
        return lottoScore;
    }

    private Lottos userPurchaseLottos(final LottoPurchase lottoPurchase) {
        return Lottos.purchaseLottos(lottoPurchase);
    }
}
