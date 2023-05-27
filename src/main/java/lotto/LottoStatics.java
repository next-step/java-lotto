package lotto;

import java.util.HashMap;
import java.util.List;

public class LottoStatics {

    private HashMap<Number, Integer> basicStatistics;
    private HashMap<Number, Integer> bonusStatistics;
    private final int lottoPrice;

    public String getProfitRatio() {
        double sum = calculateProfitSum();
        return calculateProfitRatio(sum);
    }

    private String calculateProfitRatio(double sum) {
        int matchedCount = basicStatistics.size() + bonusStatistics.size();
        if(matchedCount == 0) {
            return "0";
        }
        return String.valueOf(sum / lottoPrice / matchedCount);
    }

    public LottoStatics(WinnigLotto winningLotto, Lottos lottos) {
        basicStatistics = new HashMap<>();
        bonusStatistics = new HashMap<>();

        lottoPrice = lottos.getLottoPrice();
        List<StatisticsNumber> matchedCount = lottos.matchedLottoCount(winningLotto);

        for (StatisticsNumber staticNumber : matchedCount) {
            putStatistics(staticNumber);
        }

        winningLotto.getLottoBonusNumber();
    }

    private void putStatistics(StatisticsNumber staticNumber) {
        if(staticNumber.isBonusNumber()) {
            bonusStatistics.put(Number.createNumber(staticNumber.getMatchedCount()), basicStatistics.getOrDefault(Number.createNumber(staticNumber.getMatchedCount()), 0) + 1);
        }
        if(!staticNumber.isBonusNumber()){
            basicStatistics.put(Number.createNumber(staticNumber.getMatchedCount()), basicStatistics.getOrDefault(Number.createNumber(staticNumber.getMatchedCount()), 0) + 1);
        }
    }

    private double calculateProfitSum() {
        double sum = 0;

        for (Number number : basicStatistics.keySet()){
            sum += LottoPricePolicy.getLottoPriceByMatchCount(number.getNumberToInt(), false);
        }

        for (Number number : bonusStatistics.keySet()){
            sum += LottoPricePolicy.getLottoPriceByMatchCount(number.getNumberToInt(), true);
        }

        return sum;
    }

    public int getNumberCount(Number number) {
        return basicStatistics.getOrDefault(number, 0);
    }

    public int getBonusNumberCount(Number number) {
        return bonusStatistics.getOrDefault(number, 0);
    }
}
