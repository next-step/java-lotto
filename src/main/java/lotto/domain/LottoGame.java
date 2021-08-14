package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private final int ONE_GAME_PRICE = 1000;
    private final List<LottoTicket> tickets = new ArrayList<>();


    public LottoGame(final int price) {
        int ticketNumber = buyTicketNumber(price);
        for (int i = 0; i < ticketNumber; i++) {
            tickets.add(new LottoTicket());
        }
    }

    private int buyTicketNumber(final int price) {
        return (price / ONE_GAME_PRICE);
    }

    public int getTicketNum() {
        return tickets.size();
    }
}
