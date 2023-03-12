package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

import static lotto.domain.LottoGame.LOTTO_PRICE;

public class WinningStatistics {
    private final Map<WinningGrade, Integer> lotteryStatistics;

    public WinningStatistics(LotteryNumbers lotteryNumbers, List<Lotto> lottos) {
        Map<WinningGrade, Integer> lotteryStatistics = initStatistics();
        lottos.stream().map(lotto -> {
                    Set<Integer> lottoNumbers = new HashSet<>(lotto.getLottoNumbers());
                    return lotteryNumbers.getWinningGrade(lottoNumbers);
                })
                .forEach(winningGrade ->{
                    Integer value = lotteryStatistics.get(winningGrade);
                    lotteryStatistics.put(winningGrade, ++value);
                });

        this.lotteryStatistics = Collections.unmodifiableMap(lotteryStatistics);
    }

    private Map<WinningGrade, Integer> initStatistics() {
        Map<WinningGrade, Integer> lotteryStatistics = new HashMap<>();
        for (WinningGrade grade : WinningGrade.values()) {
            lotteryStatistics.put(grade, 0);
        }
        return lotteryStatistics;
    }

    public int getWinningNumbers(WinningGrade winningGrade) {
        return lotteryStatistics.get(winningGrade);
    }

    @Override
    public String toString() {
        return lotteryStatistics.toString();
    }

    public String getTotalRateOfReturnForPrint() {
        Integer totalSum = lotteryStatistics.keySet().stream()
                .map(key -> lotteryStatistics.get(key) * key.getPrizeMoney())
                .reduce(0, Integer::sum);

        Integer totalCount = lotteryStatistics.keySet().stream().map(lotteryStatistics::get).reduce(0, Integer::sum);

        double returnRete = (double) totalSum / (LOTTO_PRICE.multiply(totalCount).toInteger());
        return Double.toString(Math.round(returnRete * 1000) / 1000.0);
    }

    public String printInformation() {
        return lotteryStatistics.keySet().stream()
                .filter(key -> key != WinningGrade.ETC)
                .sorted(Comparator.comparing(WinningGrade::getPrizeMoney))
                .map(key -> key.getDescriptionForPrint() + "- " + lotteryStatistics.get(key) + "개")
                .collect(Collectors.joining("\n"));
    }

}
