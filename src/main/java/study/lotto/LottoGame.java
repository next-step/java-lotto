package study.lotto;

import study.lotto.helper.LottoHelper;
import study.lotto.model.Lottos;
import study.lotto.service.LottoService;
import study.lotto.view.InputView;

public class LottoGame {

    public static void main(String[] args) {
        LottoHelper lottoHelper = new LottoHelper(InputView.scanPurchaseAmount());
        lottoHelper.setManualLottoCount(InputView.scanManualLottoCount());

        LottoService lottoService = new LottoService();

        Lottos lottos = lottoService.purchaseLottos(lottoHelper);

        lottoService.checkLottoResult(lottos, lottoHelper);
    }
}
