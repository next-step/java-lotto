package step2;

import step2.View.InputView;
import step2.View.ResultView;

import java.util.List;
import java.util.Set;

public class Application {
    private static final int MAX_LOTTO_NUM = 45;
    private static final int PICK_NUMBER_COUNT = 6;

    public static void main(String[] args) {
        int ticketAmount = InputView.buyTickets();
        List<Game> games = Game.buy(ticketAmount, MAX_LOTTO_NUM, PICK_NUMBER_COUNT);
        ResultView.checkout(games);

        Winning winningNumbers = InputView.winningNumber();
        Ticket ticket = new Ticket(games);
        ResultView.analyze(ticket, winningNumbers, PICK_NUMBER_COUNT);
    }
}
