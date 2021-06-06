package lotto;

import lotto.controllers.PurchaseController;
import lotto.controllers.ResultController;
import lotto.controllers.TicketingController;
import lotto.controllers.WinningNumbersController;
import lotto.domains.Purchase;
import lotto.domains.Tickets;
import lotto.domains.WinningNumbers;

public class Main {

    public static void main(String[] args) {
        Purchase purchase = PurchaseController.run();

        Tickets tickets = TicketingController.run(purchase);

        WinningNumbers winningNumbers = WinningNumbersController.run();

        ResultController.run(tickets, winningNumbers);
    }

}
