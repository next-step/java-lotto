package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private static final int ONE_GAME_PRICE = 1000;
    private final List<LottoTicket> tickets = new ArrayList<>();

    public Lotto(final int price, final LottoNumberSelectPolicy lottoNumberSelectPolicy) {
        int ticketNumber = calTicketSize(price);
        for (int i = 0; i < ticketNumber; i++) {
            tickets.add(new LottoTicket(lottoNumberSelectPolicy));
        }
    }

    private int calTicketSize(final int price) {
        return (price / ONE_GAME_PRICE);
    }

    public int getTicketSize() {
        return tickets.size();
    }

    public void checkResult(final LottoNumbers lottoNumbers) {
        for (LottoTicket lottoTicket : tickets) {
            lottoTicket.checkResult(lottoNumbers);
        }
    }

    public List<LottoTicket> getTickets() {
        return tickets;
    }

}
