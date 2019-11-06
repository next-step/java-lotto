package step2;

import step2.View.InputView;
import step2.View.ResultView;

public class Application {
    public static void main(String[] args) {
        int ticketAmount = InputView.buyTickets();
        Ticket ticket = new Ticket(ticketAmount);
        ResultView.printTickets(ticket);
        WinningNumbers winningNumbersNumber = new WinningNumbers(InputView.getWinningNumbers());
        ResultView.printAnalysis(ticket, winningNumbersNumber);
    }
}
