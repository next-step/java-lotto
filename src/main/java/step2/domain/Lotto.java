package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private List<Ticket> tickets;

    public Lotto(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Lotto(int cnt) {
        this(makeTickets(cnt));
    }

    private static List<Ticket> makeTickets(int cnt) {

        List<Ticket> tickets = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            tickets.add(new Ticket());
        }
        return tickets;
    }


}
