package lotto;

import lotto.domain.Purchase;
import lotto.domain.WinnerNumber;
import lotto.domain.WinnerResult;
import lotto.strategy.NumberStrategy;
import lotto.strategy.RandomNumberStrategy;
import lotto.view.InputView;

import static lotto.view.ResultView.*;

public class LottoMain {

    private static final InputView INPUT_VIEW = new InputView();
    private static final NumberStrategy NUMBER_STRATEGY = new RandomNumberStrategy();

    public static void main(String[] args) {
        Purchase purchase = new Purchase(INPUT_VIEW.inputMoney(), NUMBER_STRATEGY);
        print(purchase.toString());
        WinnerNumber winnerNumber = new WinnerNumber(INPUT_VIEW.inputWinNumber());
        WinnerResult winnerResult = new WinnerResult(winnerNumber.resultLotto(), purchase.lottos());
        print(winnerResult.toString());
        resultPrint(winnerResult.rateOfReturn(purchase.amount()));
    }
}
