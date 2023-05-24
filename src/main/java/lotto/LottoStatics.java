package lotto;

import java.util.HashMap;
import java.util.List;

public class LottoStatics {

    private HashMap<Number, Integer> statistics;
    private final int totalPrice;

    public LottoStatics(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getProfitRatio(Lotto winningLotto, Lottos lottos) {
        double sum = calculateProfitSum(winningLotto, lottos.getLottoList());
        return String.valueOf(sum / lottos.getLottoTotalPrice());
    }

    public void calculateProfitStatistics(Lotto winningLotto, Lottos lottos) {
        statistics = new HashMap<>();
        List<Integer> matchedCount = lottos.matchedLottoCount(winningLotto);

        for (Integer count : matchedCount) {
            statistics.put(Number.createNumber(count), statistics.getOrDefault(Number.createNumber(count), 0) + 1);
        }
    }

    private double calculateProfitSum(Lotto winningLotto, List<Lotto> lottoList) {
        double sum = 0;
        for (Lotto lotto : lottoList) {
            int matchedCount = lotto.equalsCount(winningLotto.getLottoNumbers());
            sum += LottoPricePolicy.getLottoPriceByMatchCount(matchedCount);
        }
        return sum;
    }

    public int getNumberCount(Number number) {
        return statistics.getOrDefault(number, 0);
    }
}
