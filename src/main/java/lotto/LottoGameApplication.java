package lotto;

import lotto.domain.*;
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

        LottoTicket lastWeekWinnerTicket = LottoTicket.createFromIntegerList(LottoInputView.getLastWeekWinnerNumber());
        LottoNumber lastWeekBonusNumber = new LottoNumber(LottoInputView.getLastWeekBonusNumber());
        WinningLotto lastWeekWinningLotto = new WinningLotto(lastWeekWinnerTicket, lastWeekBonusNumber);

        List<LottoPrize> prizes = lastWeekWinningLotto.prizes(tickets);

        LottoResultView.printResult(prizes, tickets.size());
    }
}
