package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoTickets {

    private final List<LottoTicket> lottoTickets;

    public LottoTickets() {
        lottoTickets = new ArrayList<>();
    }

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public int size() {
        return lottoTickets.size();
    }

    public void add(LottoTicket lottoTicket) {
        lottoTickets.add(lottoTicket);
    }

    public LottoStatistic matching(List<Integer> winningNumbers) {
        Map<LottoRank, Integer> hashMap = new HashMap<>();
        for (LottoTicket lottoTicket : lottoTickets) {
            int matchingCount = lottoTicket.matchingTicket(winningNumbers);
            LottoRank lottoRank = LottoRank.of(matchingCount);
            hashMap.put(lottoRank, hashMap.getOrDefault(lottoRank, 0) + 1);
        }
        return new LottoStatistic(hashMap);
    }
}