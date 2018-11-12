package lotto;

import lotto.constant.Question;
import lotto.domain.Lotto;
import lotto.utils.GenerateLottoMachine;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public abstract class ConsoleMain {

    public static void main(String[] args) {
        final int lottoPurchaseAmount = InputView.IntegerQuestion(Question.PLEASE_INPUT_THE_PURCHASE_AMOUNT);
        final LottoGame lottoGame = new LottoGame(lottoPurchaseAmount, new GenerateLottoMachine());
        final List<Lotto> lottos = lottoGame.getLottos();
        ResultView.printLottos(lottoGame.getCountAvailableForPurchase(), lottos);

        final Lotto lotto = new Lotto(new GenerateLottoMachine());
        lotto.createLotto(InputView.StringQuestion(Question.PLEASE_ENTER_THE_WINNING_NUMBER_FOR_THE_LAST_WEEK));

        ResultView.printAnalysisLottoResult(lotto.getLottoNumber(), lottos, lottoPurchaseAmount);
    }

}
