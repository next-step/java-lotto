package lotto;

import lotto.domain.Purchase;
import lotto.domain.RankLotto;
import lotto.domain.WinnerNumber;
import lotto.domain.WinnerResult;
import lotto.strategy.NumberStrategy;
import lotto.strategy.RandomNumberStrategy;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.text.DecimalFormat;
import java.util.Map;

public class LottoMain {

    private static final ResultView RESULT_VIEW = new ResultView();
    private static final InputView INPUT_VIEW = new InputView();
    private static final NumberStrategy NUMBER_STRATEGY = new RandomNumberStrategy();

    public static void main(String[] args) {
        Purchase purchase = new Purchase(INPUT_VIEW.inputMoney(), NUMBER_STRATEGY);
        RESULT_VIEW.print(purchase.toString());
        WinnerNumber winnerNumber = new WinnerNumber(INPUT_VIEW.inputWinNumber());
        WinnerResult winnerResult = new WinnerResult(winnerNumber.resultLotto(), purchase.lottos());
        RESULT_VIEW.print(winnerResult.toString());
        RESULT_VIEW.resultPrint(winnerResult.rateOfReturn(purchase.amount()));
    }
}
