package lotto;

import lotto.domain.LottoGame;
import lotto.domain.LottoPrize;
import lotto.domain.LottoTicket;
import lotto.domain.WinningLotto;
import lotto.view.LottoInputView;
import lotto.view.LottoResultView;

import java.util.ArrayList;
import java.util.List;

public class LottoGameApplication {

    public static void main(String[] args) {
        try {
            List<List<Integer>> numbersForManualTicket = new ArrayList<>();
            int moneyForTicket = LottoInputView.getMoneyForTicket();
            int numberOfManualTickets = LottoInputView.getNumberOfManualTicket();
            if (numberOfManualTickets > 0) {
                numbersForManualTicket = LottoInputView.getLottoTicketNumbers(numberOfManualTickets);
            }
            List<LottoTicket> tickets = LottoGame.buy(moneyForTicket, numbersForManualTicket);

            LottoResultView.printTickets(tickets, numberOfManualTickets);

            if (tickets.isEmpty()) {
                return;
            }

            WinningLotto lastWeekWinningLotto = new WinningLotto(LottoInputView.getLastWeekWinnerNumber(), LottoInputView.getLastWeekBonusNumber());
            List<LottoPrize> prizes = lastWeekWinningLotto.prizes(tickets);

            LottoResultView.printResult(prizes, tickets.size());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
