package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Price {

    private int money;
    private static final int BASE_PRICE = 1000;

    public Price(int money) {
        this.money = money;
    }

    public int calculateTickets() {
        return money / BASE_PRICE;
    }

    public List<Ticket> buyTickets() {
        List<Ticket> tickets = new ArrayList<>();
        int ticketAmount = calculateTickets();
        for (int i = 1; i < ticketAmount; i++) {
            LottoMachine lottoMachine = new LottoMachine();
            tickets.add(new Ticket(lottoMachine.generateTicket()));
        }
        return tickets;
    }
}