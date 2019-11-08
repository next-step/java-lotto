package step2;

import step2.Model.Ticket;
import step2.Model.WinningLotto;
import step2.View.InputView;
import step2.View.ResultView;

public class Application {
    public static void main(String[] args) {
        int ticketAmount = InputView.buyTicket();
        Ticket ticket = new Ticket(ticketAmount);
        ResultView.printTickets(ticket);
        WinningLotto winningLottoNumber
                = new WinningLotto(InputView.getWinningNumbers());
        ResultView.printAnalysis(ticket, winningLottoNumber);
    }
}
