package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public final class LottoTickets {

    private final List<LottoTicket> lottoTickets;

    public LottoTickets(final List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public int size() {
        return lottoTickets.size();
    }

    public LottoStatistic matchLottoTickets(final WinningLottoTicket winningLottoTicket) {
        List<LottoRank> lottoStatistic = new ArrayList<>();
        for (LottoTicket lottoTicket : lottoTickets) {
            lottoStatistic.add(lottoTicket.matchLottoTicket(winningLottoTicket));
        }
        return new LottoStatistic(lottoStatistic);
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }
}