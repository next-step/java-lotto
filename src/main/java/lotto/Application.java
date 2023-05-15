package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.Lottos;
import lotto.domain.Numbers;
import lotto.domain.WinnerLotto;
import lotto.strategy.AutoLotto;
import lotto.strategy.LottoStrategy;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {
        InputView inputView = new InputView();
        LottoGame lottoGame = new LottoGame(inputView.getLottoPrice());

        Lottos lottos = autoLottoGameResult(lottoGame);

        ResultView.autoLottoPrint(lottos.getLottoList());
        Numbers lastWeekLottoNumbers = inputView.getLastWeekLottoNumbers();
        WinnerLotto winnerLotto = new WinnerLotto(lastWeekLottoNumbers.getLottoNumbers(), inputView.getBonusNumber());

        ResultView.printLottoStatistics(winnerLotto, lottos);

    }

    private static Lottos autoLottoGameResult(final LottoGame lottoGame) {
        LottoStrategy strategy = new AutoLotto();

        return lottoGame.automaticLottoDraw(strategy);
    }

}
