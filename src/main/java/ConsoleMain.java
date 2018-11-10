import lotto.model.Lotto;
import lotto.model.Statistics;
import lotto.model.Ticket;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class ConsoleMain {
    public static void main(String[] args) {
        int buyAmount = InputView.purcharseLotto();
        Lotto lotto = new Lotto(buyAmount);
        List<Ticket> tickets = lotto.getTickets();
        ResultView.printTicketNums(tickets);
        Statistics statistics = new Statistics(lotto.getTickets(), InputView.getPrizeNums());
        ResultView.printResult(statistics, buyAmount);
    }
}
