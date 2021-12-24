package lotto.domain;

import java.util.*;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets = new ArrayList<>();

    public LottoTickets(List<LottoTicket>... lottoTicketLists) {
        for (List<LottoTicket> lottoTicketList : lottoTicketLists) {
            this.lottoTickets.addAll(lottoTicketList);
        }
    }

    public WinningResult winningResult(LottoWinningNumbers lottoWinningNumbers, int lottoTicketsPrice) {
        return WinningResult.from(winningStaticsMap(lottoWinningNumbers), lottoTicketsPrice);
    }

    private Map<LottoRank, Integer> winningStaticsMap(LottoWinningNumbers lottoWinningNumbers) {
        Map<LottoRank, Integer> winningStaticsMap = initiateWinningStaticsMap();
        lottoTickets.forEach(lottoTicket -> {
            LottoRank lottoRank = lottoTicket.getLottoRank(lottoWinningNumbers);
            int count = winningStaticsMap.get(lottoRank) + 1;
            winningStaticsMap.put(lottoRank, count);
        });
        return winningStaticsMap;
    }

    private Map<LottoRank, Integer> initiateWinningStaticsMap() {
        Map<LottoRank, Integer> winningStaticsMap = new HashMap<>();
        Arrays.asList(LottoRank.values())
                .forEach(lottoRank -> {
                    int count = 0;
                    winningStaticsMap.put(lottoRank, count);
                });
        return winningStaticsMap;
    }

    public List<LottoTicket> getLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }

}
