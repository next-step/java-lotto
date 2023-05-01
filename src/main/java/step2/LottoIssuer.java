package step2;

import step2.domain.LottoResult;
import step2.domain.Lottos;
import step2.domain.Return;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.Map;

public class LottoIssuer {
    public static void main(String[] args) {
        int purchasePrice = InputView.getInputOfPurchasePrice();
        Lottos lottos = new Lottos(InputView.printPurchaseAmount(purchasePrice));
        InputView.printLottos(lottos.toString());

        Map<Integer, Integer> lottosResult = lottos.getResult(InputView.getInputOfWinningNumbers());
        ResultView.printStartOfResult();
        Return returnCalculator = new Return(purchasePrice);
        for (LottoResult result : LottoResult.values()) {
            int numberOfMatched = lottosResult.get(result.numbersToBeMatched);
            ResultView.printEachResult(result, numberOfMatched);
            returnCalculator.plusResult(result, numberOfMatched);
        }
        ResultView.printRateOfReturn(returnCalculator.getRateOfReturn());
    }
}
