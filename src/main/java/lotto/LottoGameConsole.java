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

public class LottoGameConsole {

    public static void main(String args[]) {
        Money money = Money.from(InputView.inputInteger(QuestionType.MONEY_FOR_BUY.getQuestion()));
        LottoGame lottoGame = new LottoGame();
        List<Lotto> lottos = lottoGame.buy(money);

        ResultView.printBoughtHistory(lottos);

        List<Integer> winningNumber = toIntegers(InputView.inputStrings(QuestionType.LAST_WEEKEND_PRIZE.getQuestion()));
        int bonusNumber = InputView.inputInteger(QuestionType.LAST_WEEKEND_BONUS.getQuestion());
        WinningLotto winningLotto = WinningLotto.from(winningNumber, bonusNumber);

        Statistics statistics = new Statistics(lottos, winningLotto);
        ResultView.printCountOfRank(statistics);
        ResultView.printReturnsOfInvestment(statistics);
    }

    private static List<Integer> toIntegers(List<String> strings) {
        return strings.stream().map(Integer::valueOf).collect(Collectors.toList());
    }

}
