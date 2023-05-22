package lotto;

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

        Lottos manualLottos = pickManualLotto(inputView, lottoGame);
        Lottos autoLottos = createAutoLotto(lottoGame, manualLottos);

        ResultView.autoLottoPrint(manualLottos.getLottoList(), autoLottos.getLottoList());

        Numbers lastWeekLottoNumbers = inputView.getLastWeekLottoNumbers();
        WinnerLotto winnerLotto = new WinnerLotto(lastWeekLottoNumbers.getLottoNumbers(), inputView.getBonusNumber());

        ResultView.printLottoStatistics(winnerLotto, autoLottos);
    }

    private static Lottos pickManualLotto(final InputView inputView, final LottoGame lottoGame) throws IOException {
        int manualLottoCount = inputView.getManualLottoCount();
        return lottoGame.manualLottoDraw(manualLottoCount, inputView.getManualLottoNumbers(manualLottoCount));
    }

    private static Lottos createAutoLotto(final LottoGame lottoGame, final Lottos manualLottos) {
        LottoStrategy strategy = new AutoLotto();
        return lottoGame.automaticLottoDraw(strategy, manualLottos.getLottoList());
    }

}
