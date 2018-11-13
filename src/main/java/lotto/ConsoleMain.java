package lotto;

import lotto.constant.Question;
import lotto.domain.Lotto;
import lotto.view.InputView;
import lotto.view.ResultView;

public abstract class ConsoleMain {

    public static void main(String[] args) {

        final int amount = InputView.IntegerQuestion(Question.PLEASE_INPUT_THE_PURCHASE_AMOUNT);
        final LottoGame lottoGame = new LottoGame(amount);
        ResultView.printLottos(lottoGame);

        final Lotto lotto = new Lotto(InputView.StringQuestion(Question.PLEASE_ENTER_THE_WINNING_NUMBER_FOR_THE_LAST_WEEK));

        ResultView.printAnalysisLottoResult(lottoGame, lotto, amount);
    }

}
