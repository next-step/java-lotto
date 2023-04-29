package lotto;

import lotto.domain.LottoGame;
import lotto.domain.Rounds;
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

        Rounds rounds = autoLottoGameResult(lottoGame);

        ResultView.autoLottoPrint(rounds.getLottoList());

        WinnerLotto winnerLotto = inputView.getLastWeekLottoNumbers();

        ResultView.printLottoStatistics(rounds.getLottoList(), winnerLotto);

    }

    private static Rounds autoLottoGameResult(final LottoGame lottoGame) {
        LottoStrategy strategy = new AutoLotto();
        return lottoGame.automaticLottoDraw(strategy);
    }

}
