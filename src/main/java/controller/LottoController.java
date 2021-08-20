package controller;

import domain.*;
import view.InputView;
import view.ResultView;

public class LottoController {

    public static void startLotto() {
        System.out.println("구입금액을 입력해주세요");
        int purchaseAmount = InputView.enterNumber();

        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int manualLottoCount = InputView.enterNumber();

        LottoManager lottoManager = new LottoManager(purchaseAmount, manualLottoCount);
        ResultView.purchaseResult(lottoManager.getPurchaseLottoCount(purchaseAmount), manualLottoCount);
        ResultView.lottoNumberResult(lottoManager.getLottos().getValue());

        WinningLotto winningLotto = null;
        while (true) {
            try {
                System.err.println("지난 주 당첨 번호를 입력해 주세요.");
                Lotto lotto = lottoManager.makeLotto(new ManualNumberStrategy());
                System.err.println("보너스 볼을 입력해 주세요.");
                BonusBall bonusBall = lottoManager.makeBonusBall(InputView.enterNumber());
                winningLotto = new WinningLotto(lotto, bonusBall);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }


        ResultView.winningResult(lottoManager.makeWinningLottoResult(winningLotto));
        ResultView.yieldResult(lottoManager.getLottoYield(purchaseAmount));
    }
}
