package lotto.domain.ticket;

import lotto.domain.result.LottoStatistics;

import java.util.List;

public class LottoTickets {

    private final List<LottoTicket> lottoTickets;

    private LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static LottoTickets of(List<LottoTicket> lottos) {
        return new LottoTickets(lottos);
    }

    public long size() {
        return lottoTickets.size();
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

    public LottoStatistics generateLottoStatistics(WinningLotto winningLotto, int lottoTicketPrice) {
        return LottoStatistics.of(lottoTickets, winningLotto, lottoTicketPrice);
    }
}
