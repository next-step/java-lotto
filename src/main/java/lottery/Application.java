package lottery;


import lottery.domain.LotteryTicket;
import lottery.domain.Money;
import lottery.domain.TicketCount;
import lottery.domain.WinningTicket;
import lottery.machine.LotteryRaffleMachine;
import lottery.machine.LotteryVendingMachine;
import lottery.supplier.BoundedUniqueRandomNumbersGenerator;
import lottery.view.InputView;
import lottery.view.ResultView;

import java.util.List;

import static lottery.domain.LotteryNumber.LOWER_BOUND_INCLUSIVE;
import static lottery.domain.LotteryNumber.UPPER_BOUND_INCLUSIVE;

public class Application {

    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }

    public void run() {
        final LotteryVendingMachine vendingMachine = new LotteryVendingMachine(
                new BoundedUniqueRandomNumbersGenerator(LOWER_BOUND_INCLUSIVE, UPPER_BOUND_INCLUSIVE));

        final Money price = InputView.inputPrice();
        final List<LotteryTicket> selectedTickets = InputView.inputSelectTickets();
        final List<LotteryTicket> boughtTickets = vendingMachine.buyLotteryTicket(price, selectedTickets);
        final LotteryRaffleMachine raffleMachine = new LotteryRaffleMachine(boughtTickets);

        ResultView.viewTicketCount(TicketCount.valueOf(boughtTickets.size()),
                TicketCount.valueOf(selectedTickets.size()));
        ResultView.viewTickets(boughtTickets);

        final WinningTicket winningTicket = InputView.inputWinningTicket();

        ResultView.viewStatistics(raffleMachine.raffle(winningTicket));
    }
}
