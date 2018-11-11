package lotto;

import lotto.constant.Question;
import lotto.utils.GenerateLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

public abstract class ConsoleMain {

    public static void main(String[] args) {

        final int lottoPurchaseAmount = InputView.IntegerQuestion(Question.PLEASE_INPUT_THE_PURCHASE_AMOUNT);
        final LottoGame lottoGame = new LottoGame(lottoPurchaseAmount, new GenerateLotto());
        ResultView.printCountOfPurchases(lottoGame.getCountAvailableForPurchase());
        ResultView.printLottos(lottoGame.getLottos());
        ResultView.newLine();

        final String lottoNumberLastWeek = InputView.StringQuestion(Question.PLEASE_ENTER_THE_WINNING_NUMBER_FOR_THE_LAST_WEEK);
        final Lotto lotto = new Lotto(new GenerateLotto());
        lotto.createLotto(lottoNumberLastWeek);
        ResultView.newLine();

        lottoGame.executeAnalysisLottoNumberMatch(lotto);
        System.out.println(ResultView.printAnalysisLottoResult(lottoGame.getLottos(), Lottos.getRate(lottoGame.getLottos(), lottoPurchaseAmount)));

    }

}
