package step2.utils;

import step2.domain.RankPrice;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoResultStatistics {
    private final int[] winnerInventory;

    private LottoResultStatistics(int[] winnerInventory) {
        this.winnerInventory = winnerInventory;
    }

    public static LottoResultStatistics newWinnerInventory(int[] winnerInventory) {
        return new LottoResultStatistics(Arrays.stream(winnerInventory)
                .filter(number -> number > 2)
                .toArray());
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
}
