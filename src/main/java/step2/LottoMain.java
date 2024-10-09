package step2;

import step2.domain.LottoGenerator;
import step2.model.LottStat;
import step2.model.LottoResult;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.List;

public class LottoMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        LottoGenerator lottoGenerator = new LottoGenerator();

        int lottoAmount = inputView.receivePurchasingAmount();
        LottoResult lottoResult = lottoGenerator.getLottos(lottoAmount);
        resultView.printLottoResult(lottoResult);

        List<Integer> winningNumber = inputView.receiveWinningNumber();
        LottStat lottoStat = lottoResult.getLottoStat(winningNumber);

    }
}
