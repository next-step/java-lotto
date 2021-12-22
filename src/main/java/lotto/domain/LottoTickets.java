package lotto.domain;

import lotto.domain.strategy.LottoTicketsGenerator;

import java.util.*;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets = new ArrayList<>();
    private final int price;

    public LottoTickets(LottoTicketsGenerator... generators) {
        int price = 0;
        for (LottoTicketsGenerator generator : generators) {
            List<LottoTicket> lottoTickets = generator.generate();
            this.lottoTickets.addAll(lottoTickets);
            price += generator.ticketsPrice();
        }
        this.price = price;
    }

    public LottoTicketsWinInformation winInformation(LottoWinningNumbers lottoWinningNumbers) {
        return LottoTicketsWinInformation.from(winningStaticsMap(lottoWinningNumbers), price);
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
