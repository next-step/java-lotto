package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Tickets {

    private List<Ticket> tickets = new ArrayList<>();

    public Tickets() {
    }

    public Tickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }


    public Stream<Ticket> getTicketStream() {
        return tickets.stream();
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void buyTickets(int ticketCount) {
        IntStream.range(0, ticketCount).forEach(
            i -> tickets.add(
                new LottoMachine().generateTicket()
            )
        );
    }
}
