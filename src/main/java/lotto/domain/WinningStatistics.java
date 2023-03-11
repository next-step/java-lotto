package lotto.domain;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static lotto.domain.LottoGame.PRICE;

public class WinningStatistics {
    private final Map<WinningGrade, Integer> lotteryStatistics;

    public WinningStatistics() {
        this.lotteryStatistics = new HashMap<>(
                Map.of(
                        WinningGrade.FIRST_PRIZE, 0,
                        WinningGrade.SECOND_PRIZE, 0,
                        WinningGrade.THIRD_PRIZE, 0,
                        WinningGrade.FORTH_PRIZE, 0,
                        WinningGrade.FIFTY_PRIZE, 0,
                        WinningGrade.ETC, 0
                )
        );
    }

    public void add(WinningGrade winningGrade) {
        Integer count = lotteryStatistics.getOrDefault(winningGrade, 0);
        lotteryStatistics.put(winningGrade, ++count);
    }

    public int getWinningNumbers(WinningGrade winningGrade) {
        return lotteryStatistics.get(winningGrade);
    }

    @Override
    public String toString() {
        return lotteryStatistics.toString();
    }

    public double getTotalRateOfReturn() {
        Integer returnSum = lotteryStatistics.keySet().stream()
                .map(key -> lotteryStatistics.get(key) * key.getPrizeMoney())
                .reduce(0, Integer::sum);

        Integer count = lotteryStatistics.keySet().stream().map(lotteryStatistics::get).reduce(0, Integer::sum);
        return (double) returnSum / (PRICE * count);

    }

    public String printInformation() {
        return lotteryStatistics.keySet().stream()
                .filter(key -> key != WinningGrade.ETC)
                .sorted(Comparator.comparing(WinningGrade::getPrizeMoney))
                .map(key -> key.getDescriptionForPrint() + "- " + lotteryStatistics.get(key) + "개")
                .collect(Collectors.joining("\n"));
    }

}
