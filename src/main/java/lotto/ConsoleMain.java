package lotto;

import lotto.constant.Question;
import lotto.domain.*;
import lotto.utils.AutomaticallyLottosGenerator;
import lotto.view.InputView;
import lotto.view.ResultView;

public abstract class ConsoleMain {

    public static void main(String[] args) {

        final Money money = new Money(InputView.IntegerQuestion(Question.PLEASE_INPUT_THE_PURCHASE_AMOUNT), InputView.IntegerQuestion(Question.PLEASE_ENTER_THE_NUMBER_OF_LOTTO_PURCHASES_MANUALLY));
        final Lottos manualPurchaseLottos = InputView.printManualPurchaseNumber(money.getManualPurchaseLottoNumber());
        final LottoGame lottoGame = new LottoGame(money, new AutomaticallyLottosGenerator(), manualPurchaseLottos);

        ResultView.printLottos(lottoGame, money);

        final WinningLotto winningLotto = new WinningLotto(new Lotto(InputView.StringQuestion(Question.PLEASE_ENTER_THE_WINNING_NUMBER_FOR_THE_LAST_WEEK)), InputView.IntegerQuestion(Question.ENTER_BONUS_BALL));

        ResultView.printAnalysisLottoResult(new LottoDto(lottoGame, winningLotto), money);

    }

}
