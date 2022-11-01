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
        if (tickets.isEmpty()) {
            return;
        }

        LottoResultView.printTickets(tickets);

        LottoTicket lastWeekWinner = LottoInputView.getLastWeekWinnerNumber();
        List<LottoPrize> prizes = LottoEarningCalculator.findPrize(tickets, lastWeekWinner);

        LottoResultView.printResult(prizes, tickets.size());
    }
}
