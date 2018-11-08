package domain;

import view.InputView;
import view.ResultView;

import java.util.List;

public class Main {

    public static void main(String [] args) {
        Lotto lotto = new Lotto();

        int purchaseAmount = InputView.inputPurchaseAmount();
        int ticketCount = lotto.countTicket(purchaseAmount);

        ResultView.printLottoTicketCount(ticketCount);

        List<Ticket> tickets = lotto.generateTickets(ticketCount);
        ResultView.printTickets(tickets);

        String winningNumbers = InputView.inputLastWeeksWinningNumbers();

        GameResult gameResult = new GameResult(lotto.playLotto(winningNumbers), purchaseAmount);
        ResultView.printLottoResults(gameResult);
    }
}
