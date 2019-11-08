package step2;

import step2.game.Ticket;
import step2.game.WinningLotto;
import step2.view.InputView;
import step2.view.ResultView;

public class LottoApplication {
    public static void main(String[] args) {
        int ticketAmount = InputView.buyTicket();
        Ticket ticket = new Ticket(ticketAmount);
        ResultView.printTickets(ticket);
        WinningLotto winningLottoNumber
                = new WinningLotto(InputView.getWinningNumbers(), InputView.getBonusNumber());
        ResultView.printAnalysis(ticket, winningLottoNumber);
    }
}
