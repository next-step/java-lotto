package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Tickets {

    private List<Ticket> tickets = new ArrayList<>();
    private TicketCount ticketCount;

    public Tickets(List<String> ticketBundle, TicketCount ticketCount) throws IllegalArgumentException {
        tickets = buyManualTicket(ticketBundle);
        validateTicketCount(ticketCount);
    }
    public Tickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Tickets(TicketCount ticketCount) {
        this.ticketCount = ticketCount;
    }

    public Stream<Ticket> getTicketStream() {
        return tickets.stream();
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void buyTickets() {
        ticketCount.createTicketCountStream().forEach(
            i -> tickets.add(
                new LottoMachine().generateTicket()
            )
        );
    }

    private void validateTicketCount(TicketCount ticketCount) throws IllegalArgumentException {
        System.out.println(tickets.size());
        if(!ticketCount.equals(new TicketCount(tickets.size()))){
            throw new IllegalArgumentException();
        }
    }

    private List<Ticket> buyManualTicket(List<String> ticketBundle) {
        LottoMachine lottoMachine = new LottoMachine();
        return ticketBundle.stream()
            .map(lottoMachine::generateManualTicket)
            .collect(Collectors.toList());
    }

    public void merge(Tickets tickets) {
        this.tickets.addAll(tickets.tickets);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Tickets tickets1 = (Tickets) o;
        return Objects.equals(tickets, tickets1.tickets) && Objects
            .equals(ticketCount, tickets1.ticketCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tickets, ticketCount);
    }
}
