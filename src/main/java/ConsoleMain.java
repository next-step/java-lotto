import lotto.model.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class ConsoleMain {
    public static void main(String[] args) {
        Amount amount = InputView.purcharseLotto();
        List<Ticket> manualTickets = InputView.getManualTicket(InputView.purcharseManual(amount));
        Lotto lotto = new Lotto(amount, new LottosAutoGenerator());
        List<Ticket> tickets = lotto.getTickets();
        ResultView.printTicketType(manualTickets.size(), tickets.size());
        ResultView.printTicketNums(tickets);
        WinningTicket winningTicket = new WinningTicket(InputView.getPrizeNums(), InputView.getBounsNum());
        Statistics statistics = new Statistics(lotto.addTickets(manualTickets), winningTicket);
        ResultView.printResult(statistics, amount::getProfitRate);
    }
}
