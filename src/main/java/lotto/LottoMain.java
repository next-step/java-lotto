package lotto;

import lotto.domain.LottoGame;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTickets;
import lotto.strategy.AutoLottoStrategy;
import lotto.ui.InputView;
import lotto.ui.ResultView;

public class LottoMain {
    public static void main(String[] args) {
        int lottoPrice = InputView.inputLottoPrice();
        LottoTickets tickets = LottoTickets.purchase(lottoPrice, new AutoLottoStrategy());
        ResultView.viewLottoCount(tickets.getCount());

        LottoGame lottoGame = new LottoGame(tickets);
        ResultView.viewLottoTickets(lottoGame);

        ResultView.viewWinningStatistics(lottoGame.gameStart(InputView.inputWinningLottoNumbers()));

    }
}
