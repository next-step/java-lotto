package lotto;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.QuestionType;
import lotto.view.ResultView;

import java.util.List;

public class LottoGameConsole {

    public static void main(String args[]) {
        Money money = Money.from(InputView.inputInteger(QuestionType.MONEY_FOR_BUY.getQuestion()));
        int countOfManual = InputView.inputInteger(QuestionType.COUNT_OF_MANUAL.getQuestion());

        LottoGame lottoGame = new LottoGame(money);
        List<Lotto> lottos = lottoGame.buy(
            new ManualLottosGenerator(InputView.inputMultilineStrings(QuestionType.NUMBERS_OF_MANUAL.getQuestion(), countOfManual)),
            new AutoLottosGenerator());

        ResultView.printBoughtHistory(lottos, countOfManual);

        WinningLotto winningLotto = WinningLotto.from(
            Lotto.fromComma(InputView.inputString(QuestionType.LAST_WEEKEND_PRIZE.getQuestion())),
            LottoNumber.from(InputView.inputInteger(QuestionType.LAST_WEEKEND_BONUS.getQuestion())));

        Statistics statistics = new Statistics(lottos, winningLotto);
        ResultView.printCountOfRank(statistics);
        ResultView.printReturnsOfInvestment(statistics);
    }
}
