package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class LottoTickets {

    private final List<LottoTicket> lottoTickets;

    public LottoTickets() {
        lottoTickets = new ArrayList<>();
    }

    public LottoTickets(final List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public int size() {
        return lottoTickets.size();
    }

    public void add(final LottoTicket lottoTicket) {
        lottoTickets.add(lottoTicket);
    }

    public LottoStatistic matching(final List<Integer> winningNumbers) {
        Map<LottoRank, Integer> lottoStatistic = new HashMap<>();
        for (LottoTicket lottoTicket : lottoTickets) {
            int matchingCount = lottoTicket.matchingTicket(winningNumbers);
            LottoRank lottoRank = LottoRank.of(matchingCount);
            lottoStatistic.put(lottoRank, lottoStatistic.getOrDefault(lottoRank, 0) + 1);
        }
        return new LottoStatistic(lottoStatistic);
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }
}