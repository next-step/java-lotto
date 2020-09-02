package lotto.domain;

import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoGame {

    public static void start() {
        ResultView.printInputMsg();

        InputMoney inputMoney = new InputMoney(InputView.inputText());
        LottoPapers lottoPapers = new LottoPapers(inputMoney.getPaperCount());

        ResultView.showBuyCount(lottoPapers.getPapersSize());
        ResultView.showLottoNumbersList(lottoPapers.getPapers());
        ResultView.showInputWinningNumber();

        WinningResult winningResult = new WinningResult(InputView.inputText());
        WinningTable winningTable = lottoPapers.makeWinningTable(winningResult.getWinninLottoNumberToIntegerList());

        ResultView.showResult(winningTable.getMatchCountTable());
        ResultView.showDelimiter();

        WinningEarningsRate winningEarningsRate = inputMoney.makeWinningEarningsRate(winningTable.getTotalWinningMoney());

        ResultView.showEarningsRate(winningEarningsRate.getEarningsRate());
    }
}
