package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private static final int ONE_GAME_PRICE = 1000;
    private final List<LottoTicket> tickets = new ArrayList<>();

    public Lotto(final int price, LottoNumberSelectPolicy lottoNumberSelectPolicy) {
        int ticketNumber = buyTicketNumber(price);
        for (int i = 0; i < ticketNumber; i++) {
            tickets.add(new LottoTicket(lottoNumberSelectPolicy));
        }
    }

    private int buyTicketNumber(final int price) {
        return (price / ONE_GAME_PRICE);
    }

    public int getTicketNum() {
        return tickets.size();
    }

    public void checkResult(final List<Integer> winningNumber) {
        for (LottoTicket lottoTicket : tickets) {
            lottoTicket.checkResult(winningNumber);
        }
    }

    public List<LottoTicket> getTickets() {
        return tickets;
    }

}
