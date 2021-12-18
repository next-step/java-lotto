package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;
    private final int price;

    LottoTickets(List<LottoTicket> lottoTickets, int price) {
        this.lottoTickets = lottoTickets;
        this.price = price;
    }

    //
    public Map<LottoRank, Integer> winningStatics(LottoWinningNumbers lottoWinningNumbers) {
        Map<LottoRank, Integer> map = createWinningStaticsMap();
        lottoTickets.forEach(lt -> {
            LottoRank lottoRank = lt.getLottoRank(lottoWinningNumbers);
            int count = map.get(lottoRank) + 1;
            map.put(lottoRank, count);
        });
        return map;
    }

    private Map<LottoRank, Integer> createWinningStaticsMap() {
        Map<LottoRank, Integer> map = new HashMap<>();
        LottoRank.lottoRanks().forEach(lottoRank -> {
            int count = 0;
            map.put(lottoRank, count);
        });
        return map;
    }

//


    public int winningPrize(LottoWinningNumbers lottoWinningNumbers) {
        return lottoTickets.stream()
                .map(l -> l.getLottoRank(lottoWinningNumbers).winningPrize())
                .reduce(0, Integer::sum);
    }

    public double earningRate(LottoWinningNumbers lottoWinningNumbers) {
        int winningPrize = winningPrize(lottoWinningNumbers);
        return (double) winningPrize / price;
    }

//    public double earningRate(Map<LottoRank, Integer> winningStatics) {
//        int winningPrize = winningPrize(winningStatics);
//        return (double) winningPrize / price;
//    }

    public int size() {
        return lottoTickets.size();
    }

//    public List<LottoTicket> getLottoTickets() {
//        return Collections.unmodifiableList(lottoTickets);
//    }

}
