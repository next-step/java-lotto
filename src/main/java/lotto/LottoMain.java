package lotto;

import lotto.domain.LottoGame;
import lotto.domain.LottoTickets;
import lotto.strategy.AutoLottoStrategy;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.List;

public class LottoMain {
    public static void main(String[] args) {
        int lottoPrice = InputView.inputLottoPrice();

        int manualCount = InputView.inputManualLottoCount();
        List<String> manualLottoTickets = InputView.inputManualLottoTickets(manualCount);

        LottoTickets allTickets = LottoTickets.purchase(lottoPrice, manualCount, manualLottoTickets, new AutoLottoStrategy());
        ResultView.viewAutoManualLottoCount(manualCount, allTickets.getCount()-manualCount);

        LottoGame lottoGame = new LottoGame(allTickets);
        ResultView.viewLottoTickets(lottoGame);

        ResultView.viewWinningStatistics(lottoGame.gameStart(InputView.inputWinningLottoNumbers()));

    }
}
