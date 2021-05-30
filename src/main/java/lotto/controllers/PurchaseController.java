package lotto.controllers;

import lotto.Lotto;
import lotto.domains.Purchase;
import lotto.enums.Message;
import lotto.views.Display;
import lotto.views.Keyboard;

public class PurchaseController implements Controller {

    private Lotto lotto;

    public PurchaseController(Lotto lotto) {
        this.lotto = lotto;
    }

    @Override
    public void run() {
        Display.show(Message.PURCHASE);

        int ticketAmount = buyTickets(Keyboard.read());

        Display.show(Message.TICKET_AMOUNT, ticketAmount);

        toTicketingController();
    }

    protected int buyTickets(String money) {
        Purchase purchase = new Purchase(money);
        savePurchase(purchase);
        return purchase.ticketsAmount();
    }

    private void savePurchase(Purchase purchase) {
        this.lotto.storage().savePurchase(purchase);
    }

    private void toTicketingController() {
        this.lotto.toTicketingController();
    }

}
