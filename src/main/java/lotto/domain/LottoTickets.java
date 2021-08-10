package lotto.domain;

import java.util.*;

public class LottoTickets {

    private final int INCREASE_COUNT = 1;
    private final int DEFAULT_COUNT = 0;

    private final List<LottoTicket> lottoTickets;

    private LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static LottoTickets of(List<LottoTicket> lottoTickets) {
        return new LottoTickets(lottoTickets);
    }

    public Map<LottoRank, Integer> getMatchRankCount(WinningLottoTicket winningLottoTicket) {
        Map<LottoRank, Integer> result = new HashMap<>();

        for (LottoTicket lottoTicket : lottoTickets) {
            LottoRank rank = winningLottoTicket.match(lottoTicket);
            result.put(rank, result.getOrDefault(rank, DEFAULT_COUNT) + INCREASE_COUNT);
        }

        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTickets that = (LottoTickets) o;
        return Objects.equals(lottoTickets, that.lottoTickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoTickets);
    }
}
