package lotto.domain;

import java.util.*;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;
    private final int price;

    LottoTickets(List<LottoTicket> lottoTickets, int price) {
        this.lottoTickets = lottoTickets;
        this.price = price;
    }

    public LottoTicketsWinInformation winInformation(LottoWinningNumbers lottoWinningNumbers) {
        return LottoTicketsWinInformation.from(winningStaticsMap(lottoWinningNumbers), price);
    }

    public Map<LottoRank, Integer> winningStaticsMap(LottoWinningNumbers lottoWinningNumbers) {
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

    public int size() {
        return lottoTickets.size();
    }

    public List<LottoTicket> getLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }

    public double getPrice() {
        return this.price;
    }
}
