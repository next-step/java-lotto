package lotto.domain;

import java.util.List;

public class Ticket {
    private List<List<Integer>> tickets;
    private static final int BASE_PRICE = 1000;
    private int money;
    private List<Integer> winningNumber;
    private Integer bonusNumber;

    public Ticket(int money) {
        this.money = money;
    }

    public Ticket() { }

    public List<List<Integer>> getTickets() {
        return tickets;
    }

    public int calculateTickets() {
        return money / BASE_PRICE;
    }

    public void buyTickets() {
        LottoMachine lottoMachine = new LottoMachine();
        int ticketAmount = calculateTickets();
        for (int i = 0; i < ticketAmount; i++) {
            // Ticket
            tickets.add(lottoMachine.generateTicket());
        }
    }
}
