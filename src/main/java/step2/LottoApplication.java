package step2;

import step2.domain.*;
import step2.view.InputView;
import step2.view.OutPutView;

public class LottoApplication {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        OutPutView outPutView = new OutPutView();

        int purchaseAmount = inputView.askPurchaseAmount();
        PurchaseMoney purchaseMoney = new PurchaseMoney(purchaseAmount);
        outPutView.showPurchaseCount(purchaseMoney.getPurchaseCount());

        PurchaseList purchaseList = new PurchaseList(purchaseMoney);
        outPutView.show(purchaseList.toString());

        String winnerInput = inputView.askWinnerInput();
        String bonusInput = inputView.askBonusInput();
        WinningLotto winningLotto = new WinningLotto(winnerInput, bonusInput);
        inputView.close();

        LottoGame lottoGame = new LottoGame(purchaseList, winningLotto);
        GameResult gameResult = lottoGame.calculateResult();
        ReturnRate returnRate = gameResult.calculateReturnRate(purchaseMoney);

        outPutView.showResultLine();
        outPutView.showGameResult(gameResult.getResult());
        outPutView.showReturnRate(returnRate.getValue(), returnRate.isProfitable());
        outPutView.showEnd();

    }
}
