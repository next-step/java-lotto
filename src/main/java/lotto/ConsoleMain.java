package lotto;

import lotto.constant.Question;
import lotto.domain.Lotto;
import lotto.domain.LottoDto;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

public abstract class ConsoleMain {

    public static void main(String[] args) {

        // 구입 금액
        final int amount = InputView.IntegerQuestion(Question.PLEASE_INPUT_THE_PURCHASE_AMOUNT);
        // 수동으로 구입할 로또의 숫자
        final int manualPurchaseLottoNumber = InputView.IntegerQuestion(Question.PLEASE_ENTER_THE_NUMBER_OF_LOTTO_PURCHASES_MANUALLY);
        // 수동 구입 로또
        final Lottos manualPurchaseLottos = InputView.printManualPurchaseNumber(manualPurchaseLottoNumber);
        // 로또 게임
        final LottoGame lottoGame = new LottoGame(amount, manualPurchaseLottos);

        ResultView.printLottos(manualPurchaseLottoNumber, lottoGame);

        final WinningLotto lotto = new WinningLotto(
                new Lotto(InputView.StringQuestion(Question.PLEASE_ENTER_THE_WINNING_NUMBER_FOR_THE_LAST_WEEK)),
                InputView.IntegerQuestion(Question.ENTER_BONUS_BALL)
        );

        ResultView.printAnalysisLottoResult(new LottoDto(lottoGame.getLottos(), lotto), amount);

    }

}
