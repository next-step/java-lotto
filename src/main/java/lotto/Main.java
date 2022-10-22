package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        Price price = new Price(inputView.enterPurchasePrice());
        Price lotteryTicketPrice = new Price(1000);

        Amount amount = price.calculateAmount(lotteryTicketPrice);
        outputView.printAmount(amount);

        LotteryTickets tickets = amount.createTickets(new LotteryTicketAutoGenerator());
        outputView.printTickets(tickets);

        LotteryTicket winningTicket = LotteryTicket.of(inputView.enterWinningNumbers());
    }
}
