package study.lotto;

import study.lotto.util.LottoNumberGenerator;
import study.lotto.view.InputView;
import study.lotto.view.ResultView;

import java.math.BigDecimal;

public class Play {


    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        BigDecimal purchaseAmount = inputView.inputPurchaseAmount();
        PurchasedLottos purchasedLottos = lottoGame.purchase(purchaseAmount);
        resultView.purchasedLottos(purchasedLottos);

        LottoNumbers winningNumbers = new LottoNumbers(LottoNumberGenerator.markedNumbers(inputView.inputWinningNumbers()));
        WinningResult winningResult = lottoGame.checkPrize(purchasedLottos, winningNumbers);
        BigDecimal profitRate = lottoGame.profitRate(purchaseAmount, winningResult.totalPrize());
        resultView.winningResult(winningResult,profitRate);
    }
}
