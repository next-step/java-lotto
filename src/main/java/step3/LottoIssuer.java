package step3;

import step3.domain.LottosTotalResult;
import step3.view.InputView;
import step3.view.LottosView;
import step3.view.ResultView;

public class LottoIssuer {
    public static void main(String[] args) {

        int purchasePrice = InputView.getInputOfPurchasePrice();
        int purchaseAmount = InputView.printPurchaseAmount(purchasePrice);

        LottoGame lottoGame = new LottoGame(purchaseAmount);
        LottosView.printLottos(lottoGame.getLottos());

        LottosTotalResult totalResult = lottoGame.getTotalResult(InputView.getInputOfWinningNumbers());

        ResultView.printTotalResult(totalResult, purchasePrice);
    }
}
