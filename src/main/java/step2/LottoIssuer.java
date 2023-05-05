package step2;

import step2.domain.LottosTotalResult;
import step2.view.InputView;
import step2.view.LottosView;
import step2.view.ResultView;

public class LottoIssuer {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();

        int purchasePrice = InputView.getInputOfPurchasePrice();
        int purchaseAmount = InputView.printPurchaseAmount(purchasePrice);

        lottoGame.generateLottos(purchaseAmount);
        LottosView.printLottos(lottoGame.getLottos());

        LottosTotalResult totalResult = lottoGame.getTotalResult(InputView.getInputOfWinningNumbers());

        ResultView.printTotalResult(totalResult, purchasePrice);
    }
}
