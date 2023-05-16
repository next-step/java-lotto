package lotto;

import java.util.HashMap;
import java.util.List;

public class LottoStatics {
    private double sum;
    private HashMap<Number, Integer> statistics;
    private int price;
    private int count;

    public LottoStatics(int totalPrice, int lottoPrice) {
        this.price = lottoPrice;
        this.count = totalPrice / lottoPrice;
    }

    public String getProfitRatio(Lotto winningLotto,  List<Lotto> lottoList) {
        calculateProfitSum(winningLotto, lottoList);
        double sum = getSum();
        return String.valueOf(sum / (price * count));
    }

    public void calculateProfitStatistics(Lotto winningLotto, List<Lotto> lottoList) {
        statistics = new HashMap<>();
        for (Lotto lotto : lottoList) {
            int matchedCount = lotto.equalsCount(winningLotto.getLottoNumbers());
            statistics.put(Number.createNumber(matchedCount), statistics.getOrDefault(Number.createNumber(matchedCount), 0) + 1);
        }
    }

    private void calculateProfitSum(Lotto winningLotto, List<Lotto> lottoList) {
        double sum = 0;
        for (Lotto lotto : lottoList) {
            int matchedCount = lotto.equalsCount(winningLotto.getLottoNumbers());
            sum += LottoPricePolicy.getLottoPriceByMatchCount(matchedCount);
        }
        this.sum = sum;
    }

    private double getSum() {
        return sum;
    }

    public int getNumberCount(Number number) {
        return statistics.getOrDefault(number, 0);
    }
}
