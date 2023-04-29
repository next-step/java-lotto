package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTickets {
    public static final int MIN_LOTTO_TICKET_COUNT = 1;
    private final List<LottoTicket> tickets;

    public LottoTickets(List<LottoTicket> tickets) {
        this.tickets = tickets;
    }

    public static LottoTickets create(int lottoTicketCount) {
        validate(lottoTicketCount);
        List<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; i < lottoTicketCount; i++) {
            tickets.add(new LottoGenerator().generateLottoNumbers());
        }
        return new LottoTickets(tickets);
    }

    private static void validate(int lottoTicketCount) {
        if (lottoTicketCount < MIN_LOTTO_TICKET_COUNT) {
            throw new IllegalArgumentException(String.format("로또 티켓은 %d장 이상 구입해야 합니다", MIN_LOTTO_TICKET_COUNT));
        }
    }

    public List<LottoTicket> getLottoTickets() {
        return Collections.unmodifiableList(tickets);
    }

    public int findLottoTicketCount() {
        return this.tickets.size();
    }
}

