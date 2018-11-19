package lotto;

import lotto.model.Lotto;
import lotto.model.Money;
import lotto.model.Statistics;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.QuestionType;
import lotto.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoGameConsole {

    public static void main(String args[]) {
        Money money = Money.from(InputView.inputInteger(QuestionType.MONEY_FOR_BUY.getQuestion()));

        int countOfManual = InputView.inputInteger(QuestionType.COUNT_OF_MANUAL.getQuestion());
        money = money.deduct(LottoGame.moneyOfCount(countOfManual));

        List<Lotto> manualLottos = InputView.inputLottos(QuestionType.NUMBERS_OF_MANUAL.getQuestion(), countOfManual);

        LottoGame lottoGame = new LottoGame();
        List<Lotto> autoLottos = lottoGame.buy(money);

        ResultView.printBoughtHistory(manualLottos, autoLottos);

        List<Integer> winningNumber = InputView.inputIntegers(QuestionType.LAST_WEEKEND_PRIZE.getQuestion());
        int bonusNumber = InputView.inputInteger(QuestionType.LAST_WEEKEND_BONUS.getQuestion());
        WinningLotto winningLotto = WinningLotto.from(winningNumber, bonusNumber);

        List<Lotto> combinedLottos = Stream
            .concat(manualLottos.stream(), autoLottos.stream())
            .collect(Collectors.toList());
        Statistics statistics = new Statistics(combinedLottos, winningLotto);
        ResultView.printCountOfRank(statistics);
        ResultView.printReturnsOfInvestment(statistics);
    }
}
