package lotto.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Game {
    private final List<Ticket> tickets = new ArrayList<>();

    public Game(int countOfTicket) {
        for (int i = 0; i < countOfTicket; i++) {
            add(randomTicket());
        }
    }

    private void add(Ticket ticket) {
        tickets.add(ticket);
    }

    private Ticket randomTicket() {
        List<Integer> numList = new ArrayList<>();
        for (int i = 1; i <= 45; i++) numList.add(i);
        Collections.shuffle(numList);

        List<Integer> ticketNumber = numList.subList(0, 6);
        Collections.sort(ticketNumber);

        return new Ticket(ticketNumber);
    }

    public List<Ticket> allTickets() {
        return tickets;
    }
}
