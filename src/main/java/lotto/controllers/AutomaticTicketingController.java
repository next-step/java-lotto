package lotto.controllers;

import lotto.AutomaticTicketing;
import lotto.Lotto;
import lotto.strategy.RandomLottoNumbers;
import lotto.domains.Tickets;
import lotto.enums.Message;
import lotto.views.Display;

public class AutomaticTicketingController implements Controller {

    private AutomaticTicketing automaticTicketing = new AutomaticTicketing(new RandomLottoNumbers());

    private Lotto lotto;

    public AutomaticTicketingController(Lotto lotto) {
        this.lotto = lotto;
    }

    @Override
    public void run() {
        int ticketsAmount = loadTicketsAmount();
        Tickets tickets = buyAutomatedTickets(ticketsAmount);

        Display.show(Message.AUTOMATIC_TICKETING, ticketsAmount);
        Display.show(tickets);

        toWinningTicketController();
    }

    protected int loadTicketsAmount() {
        return this.lotto.storage().loadPurchase().ticketsAmount();
    }

    protected Tickets buyAutomatedTickets(int amount) {
        Tickets tickets = this.automaticTicketing.newTickets(amount);
        this.lotto.storage().saveAutomatedTickets(tickets);
        return tickets;
    }

    private void toWinningTicketController() {
        this.lotto.toWinningNumbersController();
    }
}
