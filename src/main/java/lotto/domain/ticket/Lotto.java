package lotto.domain.ticket;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    public static final int LOTTO_TICKET_PRICE = 1000;

    public int getLottoTicketCount(int purchasePrice) {
        return purchasePrice / LOTTO_TICKET_PRICE;
    }

    public LottoTickets issue(int lottoTicketCount) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        LottoTicketGenerator lottoTicketGenerator = new LottoTicketGenerator();

        for (int i = 0; i < lottoTicketCount; i++) {
            lottoTickets.add(lottoTicketGenerator.getAuto());
        }

        return new LottoTickets(lottoTickets);
    }

}
