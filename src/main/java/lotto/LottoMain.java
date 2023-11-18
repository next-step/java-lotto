package lotto;

import lotto.domain.*;
import lotto.strategy.NumberStrategy;
import lotto.strategy.RandomNumberStrategy;

import java.util.List;

import static lotto.domain.GenerateLottos.autoGenerateLottos;
import static lotto.domain.GenerateLottos.manualGenerateLottos;
import static lotto.view.InputView.*;
import static lotto.view.ResultView.*;

public class LottoMain {

    private static final NumberStrategy NUMBER_STRATEGY = new RandomNumberStrategy();

    public static void main(String[] args) {

        Money money = new Money(inputMoney());
        int manualCount = inputManualCount(money.lottoCount());
        List<String> manualNumbers = inputManualNumber(manualCount);
        purchsePrint(manualCount, money.autoCount(manualCount));

        List<Lotto> manualLottos = manualGenerateLottos(manualNumbers);
        List<Lotto> autoLottos = autoGenerateLottos(money.autoCount(manualCount), NUMBER_STRATEGY);

        Purchase purchase = new Purchase(manualLottos, autoLottos);
        lottosNumberPrint(purchase.lottos());

        WinnerNumber winnerNumber = new WinnerNumber(inputWinNumber(), inputBonusNumber());
        StatisticsWinnerResult winnerResult = new StatisticsWinnerResult(winnerNumber.statisticsResult(purchase.lottos()));
        winnigStatisticsPrintString(winnerResult);
        resultPrint(winnerResult.rateOfReturn(money.price()));
    }
}
