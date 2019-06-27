package lotto.domain;

import java.util.List;

public class LottoTickets {
    static final public String DELIMITER_STRING = "\n";

    private List<LottoTicket> tickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.tickets = lottoTickets;
    }

    public int size() {
        return tickets.size();
    }

    public LottoResult checkWin(LottoTicket winner) {
        LottoResult lottoResult = new LottoResult();

        for (LottoTicket ticket : tickets) {
            lottoResult.add(ticket.correctWith(winner));
        }

        return lottoResult;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (LottoTicket ticket : tickets) {
            builder.append(ticket.toString());
            builder.append(DELIMITER_STRING);
        }

        return builder.substring(0, builder.length() - DELIMITER_STRING.length());
    }
}