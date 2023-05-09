package lotto.domain;

import java.util.*;

public class Statistics {
    private Map<PrizeType, Integer> statisticsMap = new HashMap<>();

    public Statistics() {
        statisticsMap.put(PrizeType.THREE, 0);
        statisticsMap.put(PrizeType.FOUR, 0);
        statisticsMap.put(PrizeType.FIVE, 0);
        statisticsMap.put(PrizeType.SIX, 0);
    }

    public Map<PrizeType, Integer> generate(Lottos lottos, String winLottoNumber) {
        for (Lotto lotto: lottos.getLottos()) {
            setStatisticsMap(PrizeType.findPrizeType(lotto.getNumberOfMatch(new Lotto(winLottoNumber))));
        }
        return statisticsMap;
    }

    private void setStatisticsMap(PrizeType prizeType) {
        if (prizeType != null) {
            int lottoCount = statisticsMap.get(prizeType);
            statisticsMap.put(prizeType, ++lottoCount);
        }
    }

    public double getRateOfReturn(int money) {
        int totalPrizeMoney = statisticsMap.entrySet().stream()
                .map(entry -> entry.getKey().getPrizeMoney() * entry.getValue())
                .reduce(Integer::sum).get();

        return Math.floor((double) totalPrizeMoney / money * 100) / 100.0;
    }
}
