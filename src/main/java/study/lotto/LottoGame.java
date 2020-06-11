package study.lotto;

import study.lotto.model.LottoPurchase;
import study.lotto.model.Lottos;
import study.lotto.service.LottoService;
import study.lotto.view.InputView;

public class LottoGame {

    public static void main(String[] args) {
        LottoPurchase lottoPurchase = new LottoPurchase(InputView.scanPurchaseAmount(), InputView.scanManualLottoCount());
        LottoService lottoService = new LottoService();

        Lottos lottos = lottoService.purchaseLottos(lottoPurchase);

        lottoService.checkLottoResult(lottos, lottoPurchase);
    }
}
