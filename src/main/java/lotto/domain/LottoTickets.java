package lotto.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    private LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = Collections.unmodifiableList(lottoTickets);
    }

    public static LottoTickets from(List<LottoTicket> lottoTickets) {
        return new LottoTickets(lottoTickets);
    }

    public WinStatistics calculateStatistics(WinnerNumbers winnerNumbers) {
        Map<Rank, Integer> winStatisticsDTO = new HashMap<>();
        for (LottoTicket lottoTicket : lottoTickets) {
            Rank rank = winnerNumbers.decideRank(lottoTicket);
            winStatisticsDTO.put(rank, winStatisticsDTO.getOrDefault(rank, 0) + 1);
        }
        return WinStatistics.from(winStatisticsDTO);
    }

}
