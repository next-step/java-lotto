package lotto.controllers;

import lotto.Lotto;
import lotto.Purchase;
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
        show();

        try {
            action();
            toAutomaticTicketingController();
        } catch (Exception e) {
            Display.error(e.getMessage());
        }
    }

    private void show() {
        Display.show(Message.PURCHASE);
    }

    private void action() {
        buyTickets(Keyboard.read());
    }

    protected void buyTickets(String money) {
        Purchase purchase = new Purchase(money);
        this.lotto.storage().savePurchase(purchase);
    }

    private void toAutomaticTicketingController() {
        this.lotto.toAutomaticTicketingController();
    }

}
