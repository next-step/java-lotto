package lotto.domain;

import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoGame {

    public static void start() {
        ResultView.printInputMsg();
        InputMoney inputMoney = new InputMoney(InputView.inputText());

        LottoPapers lottoPapers = new LottoPapers(inputMoney.getPaperCount());
        ResultView.showBuyCount(lottoPapers.getPapers().size());
        ResultView.showLottoNumbersList(lottoPapers.getPapers());

        ResultView.showInputWinningNumber();
        WinningResult winningResult = new WinningResult(InputView.inputText());
        winningResult.setWinningTable(
                lottoPapers.makeWinningTable(winningResult.getWinningPaper().getWinningNumbersToIntegerList())
        );

        ResultView.showResult(winningResult.getMatchCountResult());
        ResultView.showDelimiter();
        ResultView.showEarningsRate(winningResult.calculationEarningsRate(inputMoney.getMoney()));
    }
}
