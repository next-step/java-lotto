package lotto.controllers;

import lotto.AutomaticTicketing;
import lotto.Lotto;
import lotto.ManualTicketsBuilder;
import lotto.domains.Purchase;
import lotto.strategy.ManualNumbers;
import lotto.strategy.RandomLottoNumbers;
import lotto.domains.Tickets;
import lotto.enums.Message;
import lotto.views.Display;
import lotto.views.Keyboard;

public class TicketingController implements Controller {

    private AutomaticTicketing automaticTicketing = new AutomaticTicketing(new RandomLottoNumbers());

    private Lotto lotto;

    public TicketingController(Lotto lotto) {
        this.lotto = lotto;
    }

    @Override
    public void run() {
        Purchase purchase = loadPurchase();

        Tickets manualTickets = buyManualTickets(purchase);
        Tickets automatedTickets = buyAutomatedTickets(purchase.ticketsAmount() - manualTickets.size());
        Tickets allTickets = manualTickets.append(automatedTickets);

        saveTickets(allTickets);

        Display.show(Message.AUTOMATIC_TICKETING, manualTickets, automatedTickets);
        Display.show(allTickets);

        toWinningTicketController();
    }

    protected Purchase loadPurchase() {
        return this.lotto.storage().loadPurchase();
    }

    private Tickets buyManualTickets(Purchase purchase) {
        Display.show(Message.MANUAL_AMOUNT);

        ManualTicketsBuilder manualTicketsBuilder = new ManualTicketsBuilder(purchase, Keyboard.read());
        manualTicketsBuilder.newTickets(new ManualNumbers());
        return manualTicketsBuilder.build();
    }

    protected Tickets buyAutomatedTickets(int amount) {
        return this.automaticTicketing.newTickets(amount);
    }

    protected void saveTickets(Tickets tickets) {
        this.lotto.storage().saveTickets(tickets);
    }

    private void toWinningTicketController() {
        this.lotto.toWinningNumbersController();
    }
}
