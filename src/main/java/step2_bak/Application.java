package step2_bak;

import step2_bak.Data.AnalysisData;
import step2_bak.View.InputView;
import step2_bak.View.ResultView;

import java.util.List;

public class Application {
    private static final int MAX_LOTTO_NUM = 45;
    private static final int PICK_NUMBER_COUNT = 6;
    private static final int MIN_PRIZE = 3;

    public static void main(String[] args) {
        int ticketAmount = InputView.buyTickets();
        List<Game> games = Game.buy(ticketAmount, MAX_LOTTO_NUM, PICK_NUMBER_COUNT);
        ResultView.checkout(games);

        Winning winningNumbers = InputView.winningNumber();
        Ticket ticket = new Ticket(games);
        AnalysisData analysisData = ticket.analysis(winningNumbers, PICK_NUMBER_COUNT, MIN_PRIZE);
        ResultView.print(analysisData);
    }
}
