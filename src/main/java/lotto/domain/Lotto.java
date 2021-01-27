package lotto.domain;

import java.util.List;

public class Lotto {
    private List<List<Integer>> tickets;
    private static final int BASE_PRICE = 1000;

    public int calculateTickets(int money) {
        return money / BASE_PRICE;
    }

    private void buyTickets(int money) {
        LottoMachine lottoMachine = new LottoMachine();
        int ticketAmount = calculateTickets(money);
        for (int i = 0; i < ticketAmount; i++) {
            tickets.add(lottoMachine.generateTicket());
        }
    }
}
