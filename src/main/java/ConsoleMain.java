import lotto.model.Lotto;
import lotto.model.Statistics;
import lotto.model.Ticket;
import lotto.model.WinningTicket;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class ConsoleMain {
    public static void main(String[] args) {
        Long buyAmount = InputView.purcharseLotto();
        Lotto lotto = new Lotto(buyAmount);
        List<Ticket> tickets = lotto.getTickets();
        ResultView.printTicketNums(tickets);
        WinningTicket winningTicket = new WinningTicket(InputView.getPrizeNums(), InputView.getBounsNum());
        Statistics statistics = new Statistics(lotto.getTickets(), winningTicket);
        ResultView.printResult(statistics, buyAmount);
    }
}
