package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class LottoResultStatistic {
    Map<Prize, Integer> lottoResultStatistics;

    public LottoResultStatistic() {
        lottoResultStatistics = new EnumMap<>(Prize.class);
        Arrays.stream(Prize.values())
                .forEach(prize -> lottoResultStatistics.put(prize, 0));
    }

    public String getPrizeFromStatistic(Prize prize) {
        return String.valueOf(lottoResultStatistics.get(prize));
    }

    public double calculateProfit(int buyPrice) {
        return Math.floor(getTotalPrize() / (double) buyPrice * 100) / 100.0;
    }

    public void updatePrize(Prize hit) {
        lottoResultStatistics.put(hit, lottoResultStatistics.getOrDefault(hit, 0) + 1);
    }

    public Long getTotalPrize() {
        Long totalPrize = lottoResultStatistics.entrySet()
                .stream()
                .filter(count -> count.getValue() >= 1)
                .map(prize -> calculateEachPrize(prize.getKey(), prize.getKey().getValue()))
                .mapToLong(Long::valueOf)
                .sum();
        return totalPrize;
    }

    private int calculateEachPrize(Prize prize, int numberOfLotto) {
        int eachPrize = prize.getValue();
        if (eachPrize >= Prize.FOURTH.getValue()) {
            return eachPrize;
        }
        return eachPrize * numberOfLotto;
    }

}
