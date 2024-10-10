package lotto.domain.ticket;

import lotto.domain.result.Rank;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoTickets {

    private final List<LottoTicket> lottoTickets;

    private LottoTickets(List<LottoTicket> lottoTickets) {
        if (lottoTickets == null) {
            throw new IllegalArgumentException("로또 리스트가 null입니다.");
        }
        this.lottoTickets = lottoTickets;
    }

    public static LottoTickets of(List<LottoTicket> lottos) {
        return new LottoTickets(lottos);
    }

    public long size() {
        return lottoTickets.size();
    }

    public Map<Rank, Integer> countRanks(WinningLotto winningLotto) {
        Map<Rank, Integer> rankCounts = initializeRankCounts();

        for (LottoTicket lottoTicket : lottoTickets) {
            Rank rank = lottoTicket.match(winningLotto);
            rankCounts.put(rank, rankCounts.getOrDefault(rank, 0) + 1);
        }

        return rankCounts;
    }

    private Map<Rank, Integer> initializeRankCounts() {
        Map<Rank, Integer> countRanks = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            countRanks.put(rank, 0);
        }
        return countRanks;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (LottoTicket lottoTicket : lottoTickets) {
            sb.append(lottoTicket).append("\n");
        }
        return sb.toString();
    }


}
