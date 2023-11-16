package lotto;

import lotto.domain.Purchase;
import lotto.domain.WinnerNumber;
import lotto.domain.StatisticsWinnerResult;
import lotto.strategy.NumberStrategy;
import lotto.strategy.RandomNumberStrategy;

import static lotto.view.InputView.*;
import static lotto.view.ResultView.*;

public class LottoMain {

    private static final NumberStrategy NUMBER_STRATEGY = new RandomNumberStrategy();

    public static void main(String[] args) {
        Purchase purchase = new Purchase(inputMoney(), NUMBER_STRATEGY);
        print(purchase.toString());
        WinnerNumber winnerNumber = new WinnerNumber(inputWinNumber(), inputBonusNumber());
        StatisticsWinnerResult winnerResult = new StatisticsWinnerResult(winnerNumber.statisticsResult(purchase.lottos()));
        winnigStatisticsPrintString(winnerResult);
        resultPrint(winnerResult.rateOfReturn(purchase.amount()));
    }
}
