package lotto;

import lotto.domain.Purchase;
import lotto.domain.WinnerNumber;
import lotto.domain.WinnerResult;
import lotto.strategy.NumberStrategy;
import lotto.strategy.RandomNumberStrategy;

import static lotto.view.InputView.inputMoney;
import static lotto.view.InputView.inputWinNumber;
import static lotto.view.ResultView.*;

public class LottoMain {

    private static final NumberStrategy NUMBER_STRATEGY = new RandomNumberStrategy();

    public static void main(String[] args) {
        Purchase purchase = new Purchase(inputMoney(), NUMBER_STRATEGY);
        print(purchase.toString());
        WinnerNumber winnerNumber = new WinnerNumber(inputWinNumber());
        WinnerResult winnerResult = new WinnerResult(winnerNumber.resultLotto(), purchase.lottos(), winnerNumber.bonusNumber());
        print(winnerResult.toString());
        resultPrint(winnerResult.rateOfReturn(purchase.amount()));
    }
}
