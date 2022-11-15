package lotto;

import lotto.domain.LottoGame;
import lotto.domain.LottoPrize;
import lotto.domain.LottoTicket;
import lotto.domain.WinningLotto;
import lotto.view.LottoInputView;
import lotto.view.LottoResultView;

import java.util.List;

public class LottoGameApplication {

    public static void main(String[] args) {
        int moneyForTicket = LottoInputView.getMoneyForTicket();
        List<LottoTicket> tickets = LottoGame.buy(moneyForTicket);

        LottoResultView.printTickets(tickets);

        if (tickets.isEmpty()) {
            return;
        }

        WinningLotto lastWeekWinningLotto = new WinningLotto(LottoInputView.getLastWeekWinnerNumber(), LottoInputView.getLastWeekBonusNumber());

        List<LottoPrize> prizes = lastWeekWinningLotto.prizes(tickets);

        LottoResultView.printResult(prizes, tickets.size());
    }
}
