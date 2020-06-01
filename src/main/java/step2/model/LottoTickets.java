package step2.model;

import java.util.Collections;
import java.util.List;

public class LottoTickets {

    private final List<LottoTicket> lottoTickets;

    private LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static LottoTickets create(List<LottoTicket> lottoTickets) {
        return new LottoTickets(lottoTickets);
    }

    public int getTicketCount() {
        return this.lottoTickets.size();
    }

    public List<LottoTicket> getLottoTickets() {
        return Collections.unmodifiableList(this.lottoTickets);
    }

    public int calculateWinningMoney(WinningNumbers winningNumbers) {
        return this.lottoTickets.stream()
                .map(lottoTicket -> lottoTicket.getMatchCount(winningNumbers))
                .map(LottoRank::findRank)
                .map(LottoRank::getWinningMoney)
                .reduce(0, Integer::sum);
    }
}
