package step2;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    public static final int TICKET_PRICE = 1000;

    public List<Ticket> makeTickets(int money) {
        List<Ticket> tickets = new ArrayList<>();

        int ticketCount = money / TICKET_PRICE;
        for(int i=0; i<ticketCount; i++){
            tickets.add(new Ticket());
        }

        return tickets;
    }
}
