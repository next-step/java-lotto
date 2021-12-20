package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LottoTicketsWinInformation {
    private final Map<LottoRank, Integer> winningStaticsMap = new HashMap<>();
    private final LottoTickets lottoTickets;

    private LottoTicketsWinInformation(LottoTickets lottoTickets) {
        this.lottoTickets = lottoTickets;
        initiateWinningStaticsMap();
    }

    private void initiateWinningStaticsMap() {
        Arrays.asList(LottoRank.values())
                .forEach(lottoRank -> {
                    int count = 0;
                    winningStaticsMap.put(lottoRank, count);
                });
    }

    public static LottoTicketsWinInformation from(LottoTickets lottoTickets) {
        return new LottoTicketsWinInformation(lottoTickets);
    }

    public Map<LottoRank, Integer> winningStatics(LottoWinningNumbers lottoWinningNumbers) {
        lottoTickets.getLottoTickets()
                .forEach(lottoTicket -> {
                    LottoRank lottoRank = lottoTicket.getLottoRank(lottoWinningNumbers);
                    int count = winningStaticsMap.get(lottoRank) + 1;
                    winningStaticsMap.put(lottoRank, count);
                });
        return Collections.unmodifiableMap(winningStaticsMap);
    }

    public int winningPrize(LottoWinningNumbers lottoWinningNumbers) {
        return lottoTickets.getLottoTickets().stream()
                .mapToInt(lottoTicket -> lottoTicket.getLottoRank(lottoWinningNumbers).winningPrize())
                .sum();
    }

    public double earningRate(LottoWinningNumbers lottoWinningNumbers) {
        int winningPrize = winningPrize(lottoWinningNumbers);
        return (double) winningPrize / lottoTickets.getPrice();
    }

}
