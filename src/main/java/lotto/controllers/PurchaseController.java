package lotto.controllers;

import lotto.Lotto;
import lotto.Purchase;
import lotto.enums.Message;
import lotto.views.Display;
import lotto.views.Keyboard;

public class PurchaseController extends InteractionController {

    public PurchaseController(Lotto lotto) {
        super(lotto);
    }

    @Override
    protected void show() {
        Display.show(Message.PURCHASE);
    }

    @Override
    protected void action() {
        buyTickets(Keyboard.read());
    }

    protected void buyTickets(String input) {
        savePurchase(pay(input));
    }

    private void savePurchase(Purchase purchase) {
        this.lotto.storage().savePurchase(purchase);
    }

    private Purchase pay(String money) {
        return new Purchase(money);
    }

    @Override
    protected void toNextController() {
        lotto.toAutomaticTicketingController();
    }

}
