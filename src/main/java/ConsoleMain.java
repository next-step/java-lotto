import lotto.*;

import java.util.List;

public class ConsoleMain {
    public static void main(String[] args) {
        int purcharNum = InputView.purcharseLotto();
        Lotto lotto = new Lotto(purcharNum);
        List<Ticket> tickets = lotto.getTickets();
        ResultView.printTicketNums(tickets);
        Statistics statistics = new Statistics(lotto.getTickets(), InputView.getPrizeNums());
        ResultView.printResult(statistics, purcharNum*1000);
    }
}
