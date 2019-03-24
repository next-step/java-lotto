package lottery;


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
        LotteryMachine machine = new LotteryMachine();

        final Money price = InputView.inputPrice();
        final TicketCount count = machine.buyLotteryTicket(price);
        InputView.viewTicketCount(count);
        ResultView.viewTickets(machine.getTickets());

        WinningTicket winningTicket = InputView.inputWinningTicket();

        ResultView.viewStatistics(machine.raffle(winningTicket));
    }
}
