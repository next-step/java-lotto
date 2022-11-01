package lotto;

import java.util.List;

public class LottoGameApplication {

    public static void main(String[] args) {
        int moneyForTicket = LottoInputView.getMoneyForTicket();

        List<LottoTicket> tickets = LottoGame.buy(moneyForTicket);

        LottoResultView.printTickets(tickets);

        LottoTicket lastWeekWinner = LottoInputView.getLastWeekWinnerNumber();

        List<LottoPrize> prizes = LottoEarningCalculator.findPrize(tickets, lastWeekWinner);

        LottoResultView.printResult(prizes, tickets.size());
    }
}
