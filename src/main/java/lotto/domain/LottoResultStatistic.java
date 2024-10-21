package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import lotto.exception.PrizeOverFlowIsNegativeException;

public class LottoResultStatistic {
    Map<Prize, Integer> lottoResultStatistics;

    public LottoResultStatistic() {
        lottoResultStatistics = new HashMap<>();
        Arrays.stream(Prize.values())
                .forEach(prize -> lottoResultStatistics.put(prize, 0));
    }

    public String getPrizeFromStatistic(Prize prize) {
        return String.valueOf(lottoResultStatistics.get(prize));
    }

    public double calculateProfit(int buyPrice) {
        return Math.floor(getTotalPrize() / (double) buyPrice * 100) / 100.0;
    }

    public void updatePrize(Prize hit, int prize) {
        lottoResultStatistics.put(hit, lottoResultStatistics.getOrDefault(hit,0) + 1);
    }

    public int getTotalPrize() {
        int totalPrize = lottoResultStatistics.values()
                .stream()
                .reduce(0, Integer::sum);
        validtotalPrize(totalPrize);
        validOverflow(totalPrize);
        return totalPrize;
    }

    private void validtotalPrize(int totalPrize) {
        if (totalPrize > 2_000_000_000) {
            throw new IllegalArgumentException("총 상금 20억을 넘길 순 없음");
        }
    }

    private void validOverflow(int totalPrize) {
        if (totalPrize < 0) {
            throw new PrizeOverFlowIsNegativeException();
        }
    }

}
