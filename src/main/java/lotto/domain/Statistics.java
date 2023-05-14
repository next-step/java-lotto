package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Statistics {
    private Map<RankType, Integer> statisticsMap = new HashMap<>();

    public Statistics() {
        statisticsMap.put(RankType.FIRST, 0);
        statisticsMap.put(RankType.SECOND, 0);
        statisticsMap.put(RankType.THIRD, 0);
        statisticsMap.put(RankType.FOURTH, 0);
        statisticsMap.put(RankType.FIFTH, 0);
    }

    public Map<RankType, Integer> generate(Lottos lottos, String winLottoNumber, int bonusNumber) {
        for (Lotto lotto: lottos.getLottos()) {
            int numberOfMatch = lotto.getNumberOfMatch(new Lotto(winLottoNumber));

            RankType rankType = RankType.findRankType(numberOfMatch, lotto.isMatchNumber(new Number(bonusNumber)));
            setStatisticsMap(rankType);
        }
        return statisticsMap;
    }

    private void setStatisticsMap(RankType rankType) {
        if (rankType != RankType.MISS) {
            int lottoCount = statisticsMap.get(rankType);
            statisticsMap.put(rankType, ++lottoCount);
        }
    }

    public double getRateOfReturn(int money) {
        int totalPrizeMoney = statisticsMap.entrySet().stream()
                .map(entry -> entry.getKey().getPrizeMoney() * entry.getValue())
                .reduce(Integer::sum).get();

        return Math.floor((double) totalPrizeMoney / money * 100) / 100.0;
    }

    public String toStringtStatisticsMap() {
        return statisticsMap.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .map(entry -> entry.getKey() + "-" + entry.getValue() + "개\n")
                .collect(Collectors.joining());
    }
}
