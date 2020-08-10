package lotto.domain;

import java.util.List;
import java.util.Map;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class LottoStatistics {
    private final LottoPurchase lottoPurchase;
    private final Map<LottoWinningAndPrizeMoney, Long> statistics;

    LottoStatistics(LottoPurchase lottoPurchase, final List<LottoWinningAndPrizeMoney> allMatchCount) {
        this.lottoPurchase = lottoPurchase;
        this.statistics = allMatchCount.stream()
                                       .filter(LottoWinningAndPrizeMoney::isNotLose)
                                       .collect(groupingBy(identity(), counting()))
        ;
    }

    public static LottoStatistics fromAllMatchCount(LottoPurchase lottoPurchase, List<LottoWinningAndPrizeMoney> allMatchCount){
        return new LottoStatistics(lottoPurchase, allMatchCount);
    }

    public long getTotalMatchCount(LottoWinningAndPrizeMoney lottoWinningAndPrizeMoney){
        if (!statistics.containsKey(lottoWinningAndPrizeMoney)){
            return 0;
        }
        return statistics.get(lottoWinningAndPrizeMoney);
    }

    public long getTotalWinPrizeMoney(){
        return statistics.entrySet()
                  .stream()
                  .mapToLong(e -> e.getKey().getPrizeMoney() * e.getValue())
                  .sum()
            ;
    }

    public double getGrossProfit(){
        double totalWinPrizeMoney = getTotalWinPrizeMoney();
        double purchaseAmount = lottoPurchase.getPurchaseAmount();
        double result = totalWinPrizeMoney / purchaseAmount;
        return Math.floor(result * 100) / 100;
    }
}
