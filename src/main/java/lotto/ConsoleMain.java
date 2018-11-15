package lotto;

import lotto.constant.Question;
import lotto.domain.Lotto;
import lotto.domain.LottoDto;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

public abstract class ConsoleMain {

    public static void main(String[] args) {

        final int amount = InputView.IntegerQuestion(Question.PLEASE_INPUT_THE_PURCHASE_AMOUNT);
        final LottoGame lottoGame = new LottoGame(amount);
        ResultView.printLottos(lottoGame);

        final WinningLotto lotto = new WinningLotto(
                new Lotto(InputView.StringQuestion(Question.PLEASE_ENTER_THE_WINNING_NUMBER_FOR_THE_LAST_WEEK)),
                InputView.IntegerQuestion(Question.ENTER_BONUS_BALL)
        );

        ResultView.printAnalysisLottoResult(new LottoDto(lottoGame.getLottos(), lotto), amount);

    }

}
