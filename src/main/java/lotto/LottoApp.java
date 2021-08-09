package lotto;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoApp {
    private final InputView inputView;
    private final ResultView resultView;

    private LottoApp() {
        this.inputView = new InputView();
        this.resultView = new ResultView();
    }

    public static void main(String[] args) {
        LottoApp lottoApp = new LottoApp();
        lottoApp.run();
    }

    private void run() {
        inputView.printPurchasePriceInputMessage();
        int purchaseAmount = inputView.inputPurchasePrice();
        inputView.executeNextLine();
        Lottos lottos = new Lottos(purchaseAmount);
        resultView.printLottoCount(lottos.getSize());
        resultView.printLottos(lottos);

        inputView.printWinningNumbersInputMessage();
        Lotto winningNumbers = new Lotto(inputView::inputWinningNumbers);
        inputView.printBonusNumberInputMessage();
        List<WinningRank> winningRanks = WinningRank.findWinningRanks(lottos, new LotteryNumbers(winningNumbers,
                LottoNumber.valueOf(inputView.inputBonusNumber())));

        resultView.printNewLine();
        resultView.printWinningStatistics(purchaseAmount, winningRanks);
    }
}
