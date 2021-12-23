package lotto.domain;

import java.util.Collections;
import java.util.Map;

public class LottoTicketsWinInformation {
    private final Map<LottoRank, Integer> winningStaticsMap;
    private final int lottoTicketsPrice;

    private LottoTicketsWinInformation(Map<LottoRank, Integer> winningStaticsMap, int lottoTicketsPrice) {
        this.winningStaticsMap = winningStaticsMap;
        this.lottoTicketsPrice = lottoTicketsPrice;
    }


    public static LottoTicketsWinInformation from(Map<LottoRank, Integer> winningStaticsMap, int price) {
        return new LottoTicketsWinInformation(winningStaticsMap, price);
    }

    public Map<LottoRank, Integer> winningStatics() {
        return Collections.unmodifiableMap(winningStaticsMap);
    }

    public int winningPrize() {
        return winningStaticsMap.entrySet().stream().mapToInt(entry -> {
            LottoRank lottoRank = entry.getKey();
            int count = entry.getValue();
            int prize = lottoRank.winningPrize();
            return count * prize;
        }).sum();
    }

    public double earningRate() {
        return (double) winningPrize() / lottoTicketsPrice;
    }

}
