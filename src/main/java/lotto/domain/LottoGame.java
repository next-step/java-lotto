package lotto.domain;

import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoGame {

    public static void start() {
        ResultView.printInputMsg();
        InputMoney inputMoney = new InputMoney(InputView.inputText());

        LottoPapers lottoPapers = new LottoPapers(inputMoney.getMoney());
        ResultView.printBuyCount(lottoPapers.getPapersCount());

        System.out.println(lottoPapers.getPaperNumbersToString());
        ResultView.printInputWinningNumber();

        WinningResult winningResult = new WinningResult(InputView.inputText());
        lottoPapers.getPapers()
                .stream()
                .forEach(lottoPaper -> {
                    winningResult.setAutoIncrement(lottoPaper.getLottoNumbers());
                });

        ResultView.printResult(winningResult.getMatchCountResult());
        ResultView.printDelimiter();
        ResultView.printEarningsRate(winningResult.calculationEarningsRate(inputMoney.getMoney()));
    }
}
