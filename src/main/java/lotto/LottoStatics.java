package lotto;

import java.util.HashMap;
import java.util.List;

public class LottoStatics {

    private HashMap<LottoPricePolicy, Integer> basicStatistics;
    private final int lottoPrice;

    public double getProfitRatio() {
        double sum = calculateProfitSum();
        return calculateProfitRatio(sum);
    }

    private double calculateProfitRatio(double sum) {
        int matchedCount = basicStatistics.size();
        if(matchedCount == 0) {
            return 0;
        }
        return sum / lottoPrice / matchedCount;
    }

    public LottoStatics(WinnigLotto winningLotto, Lottos lottos) {
        basicStatistics = new HashMap<>();

        lottoPrice = lottos.getLottoPrice();
        List<StatisticsNumber> matchedCount = lottos.matchedLottoCount(winningLotto);

        for (StatisticsNumber staticNumber : matchedCount) {
            putStatistics(staticNumber);
        }
    }

    private void putStatistics(StatisticsNumber staticNumber) {
        int matchedCount = staticNumber.getMatchedCount();
        boolean isBonusNumber = staticNumber.isBonusNumber();

        basicStatistics.put(LottoPricePolicy.find(matchedCount, isBonusNumber), basicStatistics.getOrDefault(LottoPricePolicy.find(matchedCount, isBonusNumber), 0) + 1);
    }

    private double calculateProfitSum() {
        double sum = 0;

        for (LottoPricePolicy lottoPricePolicy : basicStatistics.keySet()){
            sum += lottoPricePolicy.getWinningAmount();
        }
        return sum;
    }

    public int getNumberCount(LottoPricePolicy lottoPricePolicy) {
        return basicStatistics.getOrDefault(lottoPricePolicy, 0);
    }
}