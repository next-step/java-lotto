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

    public LottoResult checkWin(LottoTicket winner, int bonusBall) {
        LottoResult lottoResult = new LottoResult();

        for (LottoTicket ticket : tickets) {
            int numOfCorrect = ticket.correctWith(winner);
            lottoResult.add(LottoWin.valueOf(numOfCorrect, winner.hasBonus(bonusBall)));
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