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

        buyTickets(Keyboard.read());

        toAutomaticTicketingController();
    }

    protected void buyTickets(String money) {
        Purchase purchase = new Purchase(money);
        this.lotto.storage().savePurchase(purchase);
    }

    private void toAutomaticTicketingController() {
        this.lotto.toAutomaticTicketingController();
    }

}
