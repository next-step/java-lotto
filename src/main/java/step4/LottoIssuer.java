package step4;

import step4.view.LottosView;
import step4.domain.LottosTotalResult;
import step4.view.InputView;
import step4.view.ResultView;

import java.util.List;

public class LottoIssuer {
    public static void main(String[] args) {
        int purchasePrice = InputView.getInputOfPurchasePrice();
        int numberOfManualLotto = InputView.getInputOfNumberOfManualLotto(purchasePrice);
        List<List<Integer>> manualLottos = InputView.getInputOfManualLottoNumbers(numberOfManualLotto);
        int numberOfAutoLotto = InputView.printPurchaseAmount(numberOfManualLotto, purchasePrice);

        LottoGame lottoGame = new LottoGame(manualLottos, numberOfAutoLotto);
        LottosView.printLottos(lottoGame.getLottos());

        List<Integer> winningNumbers = InputView.getInputOfWinningNumbers();
        int bonusNumber = InputView.getInputOfBonusNumber();
        LottosTotalResult totalResult = lottoGame.getTotalResult(winningNumbers, bonusNumber);

        ResultView.printTotalResult(totalResult, purchasePrice);
    }
}
