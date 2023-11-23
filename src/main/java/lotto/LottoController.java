package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoBundle;
import lotto.domain.LottoResult;
import lotto.strategy.LottoGenerator;
import lotto.strategy.LottoRandomGenerator;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Map;

public class LottoController {

    private static InputView inputView = new InputView();
    private static ResultView resultView = new ResultView();
    private static LottoGenerator lottoRandomGenerator = new LottoRandomGenerator();

    public static void main(String[] args) {
        int purchasePrice = inputView.askPurchasePrice();

        LottoBundle lottoBundle = new LottoBundle(lottoRandomGenerator, purchasePrice);
        resultView.printPurchaseInfo(lottoBundle);

        Lotto winningLotto = inputView.askLottoWinningNumbers();
        Map<LottoResult, Integer> lottoResults = lottoBundle.checkWinningResult(winningLotto);
        resultView.printWinningStatistics(purchasePrice, lottoResults);
    }
}
