package lotto;

import lotto.domain.LottoGame;
import lotto.domain.LottoTickets;
import lotto.factory.ManualLottoFactory;
import lotto.strategy.AutoLottoStrategy;
import lotto.strategy.ManualLottoStrategy;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.List;

public class LottoMain {
    public static void main(String[] args) {
        int lottoPrice = InputView.inputLottoPrice();

        int manualCount = InputView.inputManualLottoCount();
        List<String> manualLottoTickets = InputView.inputManualLottoTickets(manualCount);
        LottoTickets manualTickets = ManualLottoFactory.createTickets(manualLottoTickets);

        LottoTickets autoTickets = LottoTickets.purchase(lottoPrice, manualCount, new AutoLottoStrategy());
        ResultView.viewAutoManualLottoCount(manualTickets.getCount(), autoTickets.getCount());

        LottoGame lottoGame = new LottoGame(LottoTickets.merge(manualTickets, autoTickets));
        ResultView.viewLottoTickets(lottoGame);

        ResultView.viewWinningStatistics(lottoGame.gameStart(InputView.inputWinningLottoNumbers()));

    }
}
