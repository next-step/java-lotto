package lotto.domain;

import java.util.List;

public class LottoTickets {

    private final List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> tickets) {
        this.lottoTickets = tickets;
    }

    public LottoResult matchingResultWith(WinningNumbers winningNumbers) {
        return new LottoResult(winningNumbers, lottoTickets);
    }

    public int count() {
        return lottoTickets.size();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (LottoTicket ticket : lottoTickets) {
            stringBuilder.append(ticket.toString());
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }

    public void combineWith(LottoTickets others) {
        lottoTickets.addAll(others.lottoTickets);
    }
}
