package lotto.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoGame {

    private final List<LottoTicket> lottoTickets;

    private final WinningTicket winningTicket;

    public LottoGame(List<LottoTicket> lottoTickets, WinningTicket winningTicket) {
        this.lottoTickets = lottoTickets;
        this.winningTicket = winningTicket;
    }

    public RankResults start() {
        Map<Rank, Integer> ranks = initLottoResults();

        for (LottoTicket lottoTicket : lottoTickets) {
            Rank rank = winningTicket.getRank(lottoTicket);
            if (rank.isMiss()) {
                continue;
            }
            int count = ranks.get(rank);
            ranks.put(rank, count + 1);
        }

        return new RankResults(convertResultList(ranks));
    }

    private Map<Rank, Integer> initLottoResults() {
        Map<Rank, Integer> rankMap = new LinkedHashMap<>();
        for (Rank rank : Rank.values()) {
            if (rank.isMiss()) {
                continue;
            }
            rankMap.putIfAbsent(rank, 0);
        }
        return rankMap;
    }

    private List<RankResult> convertResultList(Map<Rank, Integer> ranks) {
        return ranks.entrySet().stream()
                .map(entry -> new RankResult(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

}
