package lottery;


import lottery.domain.LotteryTicket;
import lottery.domain.Money;
import lottery.domain.TicketCount;
import lottery.domain.WinningTicket;
import lottery.machine.LotteryMachine;
import lottery.view.InputView;
import lottery.view.ResultView;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }

    public void run() {
        final LotteryMachine machine = new LotteryMachine();

        final Money price = InputView.inputPrice();
        final List<LotteryTicket> selectedTickets = InputView.inputSelectTickets();
        final List<LotteryTicket> boughtTickets = machine.buyLotteryTicket(price, selectedTickets);

        ResultView.viewTicketCount(new TicketCount(boughtTickets.size()),
                new TicketCount(selectedTickets.size()));
        ResultView.viewTickets(boughtTickets);

        final WinningTicket winningTicket = InputView.inputWinningTicket();

        ResultView.viewStatistics(machine.raffle(winningTicket));
    }
}
