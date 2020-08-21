package lotto.domain;

import java.util.EnumMap;

public class LottoStatistics {
    private final LottoTicket winningTicket;

    public LottoStatistics(LottoTicket winningTicket) {
        this.winningTicket = winningTicket;
    }

    public LottoResult getLottoResult(LottoTickets lottoTickets) {
        EnumMap<Rank, Integer> lottoResultMap = new EnumMap<>(Rank.class);
        lottoTickets.getCountOfMatchList(winningTicket)
                    .forEach(count -> addLottoResult(lottoResultMap, Rank.getRankByCountOfMatch(count)));

        return new LottoResult(lottoResultMap);
    }

    private void addLottoResult(EnumMap<Rank, Integer> lottoResultMap, Rank rank) {
        lottoResultMap.put(rank, lottoResultMap.getOrDefault(rank, 0) + 1);
    }

}
