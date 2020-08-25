package step2.utils;

import step2.domain.RankPrice;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoResultStatistics {
    int[] winnerInventory;

    public LottoResultStatistics(int[] winnerInventory) {
        this.winnerInventory = winnerInventory;
        filterWinnerInventory();
    }

    public Map<RankPrice, Long> getWinningPriceDetails() {
        return Arrays.stream(this.winnerInventory)
                .mapToObj(RankPrice::valueOf)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public double getFinalProfit(float buyMoney) {
        int winnedMoney = Arrays.stream(this.winnerInventory)
                .mapToObj(RankPrice::valueOf)
                .mapToInt(RankPrice::getWinedMoney)
                .sum();

        return Math.round(winnedMoney / buyMoney * 100.0) / 100.0;
    }

    private void filterWinnerInventory() {
        this.winnerInventory = Arrays.stream(this.winnerInventory)
                .filter(number -> number > 2)
                .toArray();
    }
}
