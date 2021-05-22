package lotto.controllers;

import java.util.List;

import lotto.AutomaticTicketing;
import lotto.Lotto;
import lotto.Ticket;
import lotto.enums.Message;
import lotto.views.Display;

public class AutomaticTicketingController implements Controller {

    private AutomaticTicketing automaticTicketing = new AutomaticTicketing();

    private Lotto lotto;

    public AutomaticTicketingController(Lotto lotto) {
        this.lotto = lotto;
    }

    @Override
    public void run() {
        int amount = loadTicketsAmount();
        List<Ticket> tickets = buyNewTickets(amount);

        displayTicketAmount(amount);
        displayTickets(tickets);

        toWinningTicketController();
    }

    protected int loadTicketsAmount() {
        return this.lotto.storage().loadPurchase().ticketsAmount();
    }

    protected List<Ticket> buyNewTickets(int amount) {
        List<Ticket> tickets = this.automaticTicketing.newTickets(amount);
        this.lotto.storage().saveAutomatedTickets(tickets);
        return tickets;
    }

    private void displayTicketAmount(int amount) {
        Display.show(Message.AUTOMATIC_TICKETING, amount);
    }

    private void displayTickets(List<Ticket> tickets) {
        for (Ticket ticket : tickets) {
            Display.show(ticket);
        }
    }

    private void toWinningTicketController() {
        this.lotto.toWinningTicketController();
    }
}
