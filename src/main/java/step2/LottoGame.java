package step2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoGame {
    private static final int TICKET_PRICE = 1000;

    public List<Ticket> makeTickets(int money) {
        List<Ticket> tickets = new ArrayList<>();

        int ticketCount = money / TICKET_PRICE;
        for(int i=0; i<ticketCount; i++){
            tickets.add(new Ticket());
        }

        return tickets;
    }

}
