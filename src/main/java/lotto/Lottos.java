package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Lottos {

    private List<Lotto> lottoList;
    private int count;
    private double sum;

    private HashMap<Number, Integer> statistics;

    private static final int PRICE = 1000;

    public Lottos(int inputPrice) {
        count = inputPrice / PRICE;
    }

    public void makeLottos() {
        lottoList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottoList.add(new Lotto());
        }
    }

    public void shuffleLottos(LottoBalls lottoBalls) {
        for (Lotto lotto : lottoList) {
            lotto.shuffleLottoNumber(lottoBalls);
        }
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public String getProfitRatio(List<Number> list) {
        calculateProfitSum(list);
        double sum = getSum();
        return String.valueOf(sum / (PRICE * count));
    }

    public void calculateProfitStatistics(List<Number> list) {
        statistics = new HashMap<>();
        for (Lotto lotto : lottoList) {
            int matchedCount = lotto.equalsCount(list);
            statistics.put(Number.createNumber(matchedCount), statistics.getOrDefault(Number.createNumber(matchedCount), 0) + 1);
        }
    }

    private void calculateProfitSum(List<Number> list) {
        double sum = 0;
        for (Lotto lotto : lottoList) {
            int matchedCount = lotto.equalsCount(list);
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
