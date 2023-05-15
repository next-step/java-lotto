package step3;

import step3.domain.LottosTotalResult;
import step3.view.InputView;
import step3.view.LottosView;
import step3.view.ResultView;

import java.util.List;

public class LottoIssuer {
    public static void main(String[] args) {

        int purchasePrice = InputView.getInputOfPurchasePrice();
        int purchaseAmount = InputView.printPurchaseAmount(purchasePrice);

        LottoGame lottoGame = new LottoGame(purchaseAmount);
        LottosView.printLottos(lottoGame.getLottos());

        List<Integer> winningNumbers = InputView.getInputOfWinningNumbers();
        int bonusNumber = InputView.getInputOfBonusNumber();
        LottosTotalResult totalResult = lottoGame.getTotalResult(winningNumbers, bonusNumber);

        ResultView.printTotalResult(totalResult, purchasePrice);
    }
}
