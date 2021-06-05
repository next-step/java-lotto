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
        Purchase purchase = buyTickets(Keyboard.read());

        Display.show(Message.TICKET_AMOUNT, purchase.ticketsAmount());
    }

    protected Purchase buyTickets(String money) {
        Purchase purchase = new Purchase(money);
        savePurchase(purchase);
        return purchase;
    }

    private void savePurchase(Purchase purchase) {
        this.lotto.storage().savePurchase(purchase);
    }

}
