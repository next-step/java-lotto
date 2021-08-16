package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private static final int ONE_GAME_PRICE = 1000;
    private final List<LottoTicket> tickets = new ArrayList<>();

    public Lotto(final int price, final LottoNumberSelectPolicy lottoNumberSelectPolicy) {
        int ticketNumber = calculateTicketSize(price);
        for (int i = 0; i < ticketNumber; i++) {
            tickets.add(new LottoTicket(lottoNumberSelectPolicy));
        }
    }

    public int size() {
        return tickets.size();
    }

    public List<LottoTicket> getTickets() {
        return Collections.unmodifiableList(tickets);
    }

    private int calculateTicketSize(final int price) {
        return (price / ONE_GAME_PRICE);
    }

    public void checkResult(final LottoNumbers lottoNumbers) {
        for (LottoTicket lottoTicket : tickets) {
            lottoTicket.checkResult(lottoNumbers);
        }
    }

}
