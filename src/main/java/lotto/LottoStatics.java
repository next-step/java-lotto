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

    public String getProfitRatio(List<Number> winningList,  List<Lotto> lottoList) {
        calculateProfitSum(winningList, lottoList);
        double sum = getSum();
        return String.valueOf(sum / (price * count));
    }

    public void calculateProfitStatistics(List<Number> winningList, List<Lotto> lottoList) {
        statistics = new HashMap<>();
        for (Lotto lotto : lottoList) {
            int matchedCount = lotto.equalsCount(winningList);
            statistics.put(Number.createNumber(matchedCount), statistics.getOrDefault(Number.createNumber(matchedCount), 0) + 1);
        }
    }

    private void calculateProfitSum(List<Number> winningList, List<Lotto> lottoList) {
        double sum = 0;
        for (Lotto lotto : lottoList) {
            int matchedCount = lotto.equalsCount(winningList);
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
