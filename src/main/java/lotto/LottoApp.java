package lotto;

import lotto.model.Lottos;
import lotto.model.WinningNumbers;
import lotto.model.WinningRank;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoApp {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.printPurchasePriceInputMessage();
        int purchaseAmount = inputView.inputPurchasePrice();
        inputView.executeNextLine();
        Lottos lottos = new Lottos(purchaseAmount);

        ResultView resultView = new ResultView();
        resultView.printLottoCount(lottos.getSize());
        resultView.printLottos(lottos);

        inputView.printWinningNumbersInputMessage();
        WinningNumbers winningNumbers = new WinningNumbers(inputView.inputWinningNumbers());
        List<WinningRank> winningRanks = WinningRank.findWinningRanks(lottos, winningNumbers);

        resultView.printNewLine();
        resultView.printWinningStatistics(purchaseAmount, winningRanks);
    }
}
