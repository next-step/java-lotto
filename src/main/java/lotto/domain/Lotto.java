package lotto.domain;

import lotto.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Lotto {

    private List<Ticket> tickets = new ArrayList<>();

    public List<Ticket> generateTickets(int autoTicketCount, List<String> manualTickets) {
        generateAutoTickets(autoTicketCount);
        generateManualTickets(manualTickets);

        return this.tickets;
    }

    private List<Ticket> generateAutoTickets(int count) {
        IntStream.range(0, count)
                .mapToObj(i -> new Ticket(Utils.generateRandomNumbers()))
                .forEach(ticket -> this.tickets.add(ticket));

        return this.tickets;
    }

    private List<Ticket> generateManualTickets(List<String> manualNumbers) {
        manualNumbers.stream()
                .map(manualNumber -> manualNumber.split(", "))
                .forEach(this::convertToTicket);

        return this.tickets;
    }

    private void convertToTicket(String[] str) {
        List<Integer> list = new ArrayList<>();
        for(String s : str) {
            list.add(Integer.parseInt(s));
        }
        this.tickets.add(new Ticket(list));
    }

    public List<Ticket> getTickets() {
        return this.tickets;
    }
}
