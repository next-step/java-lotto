package lotto;

import java.util.HashMap;
import java.util.List;

public class LottoStatics {

    private HashMap<Number, Integer> basicStatistics;
    private HashMap<Number, Integer> bonusStatistics;

    public LottoStatics() {
    }

    public String getProfitRatio(WinnigLotto winningLotto, Lottos lottos) {
        double sum = calculateProfitSum(winningLotto, lottos.getLottoList());
        return String.valueOf(sum / lottos.getLottoTotalPrice());
    }

    public void calculateProfitStatistics(WinnigLotto winningLotto, Lottos lottos) {
        basicStatistics = new HashMap<>();
        bonusStatistics = new HashMap<>();

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

    private double calculateProfitSum(WinnigLotto winningLotto, List<Lotto> lottoList) {
        double sum = 0;
        for (Lotto lotto : lottoList) {
            int matchedCount = lotto.equalsCount(winningLotto.getWinnigLottoNumbers());
            boolean isBonusMatched = lotto.isEqualsBonusNumber(winningLotto.getLottoBonusNumber());
            sum += LottoPricePolicy.getLottoPriceByMatchCount(matchedCount, isBonusMatched);
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
