package lotto;

import lotto.domain.LottoEarningCalculator;
import lotto.domain.LottoGame;
import lotto.domain.LottoPrize;
import lotto.domain.LottoTicket;
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

        LottoTicket lastWeekWinnerTicket = new LottoTicket(LottoInputView.getLastWeekWinnerNumber());
        int lasWeekBonusNumber = LottoInputView.getLastWeekBonusNumber();

        List<LottoPrize> prizes = LottoEarningCalculator.findPrize(tickets, lastWeekWinnerTicket);

        LottoResultView.printResult(prizes, tickets.size());
    }
}
