package controller;

import domain.Lotto;
import domain.LottoManager;
import domain.LottoPrice;
import domain.WinningLotto;
import view.InputView;
import view.ResultView;

public class LottoController {

    public static void startLotto() {
        System.out.println("구입금액을 입력해주세요");
        int purchaseAmount = InputView.enterNumber();

        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int manualLottoCount = InputView.enterNumber();

        System.out.println("수동으로 구매할 번호를 입력해주세요");
        int manualLottos[][] = InputView.enterManualLotto(manualLottoCount);

        LottoManager lottoManager = new LottoManager(Lotto.calcPurchaseLottoCount(purchaseAmount - manualLottoCount * LottoPrice.LOTTO_PRICE), manualLottos);

        ResultView.purchaseResult(Lotto.calcPurchaseLottoCount(purchaseAmount), manualLottoCount);
        ResultView.lottoNumberResult(lottoManager.getLottos().getValue());

        WinningLotto winningLotto = InputView.enterWinningLotto();

        ResultView.winningResult(lottoManager.makeWinningLottoResult(winningLotto));
        ResultView.yieldResult(lottoManager.getLottoYield(purchaseAmount));
    }
}
