package lotto.view;

import lotto.domain.Ticket;
import lotto.domain.Tickets;

public class ResultView {

    public void printTickets(Tickets tickets) {
        for (Ticket ticket : tickets.getTickets()) {
            System.out.println(ticket.getNumbers());
        }
    }

}
