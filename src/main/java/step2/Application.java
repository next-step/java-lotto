package step2;

import step2.View.InputView;
import step2.View.ResultView;

public class Application {
    public static void main(String[] args) {
        int ticketAmount = InputView.buyTickets();
        // 로직처리
        // ResultView.printTickets
        Ticket ticket = new Ticket(ticketAmount);
        ResultView.printTickets(ticket);

//        Set<Integer> winningNumber = InputView.getWinningNumbers();
        // 로직처리
        // ResultView.printAnalysis()
    }
}
