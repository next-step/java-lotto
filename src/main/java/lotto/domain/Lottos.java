package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {

    public static final int LOTTO_PRICE = 1000;

    private List<Lotto> lottoList;
    private Map<Integer, Integer> result;
//    private double profitRate;

    public Lottos(int amount) {
        this.lottoList = new ArrayList<>();
        this.result = new HashMap<>();

        int n = amount / LOTTO_PRICE;
        for (int i = 0; i < n; i++) {
            this.lottoList.add(new Lotto());
        }
    }

    public Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
        this.result = new HashMap<>();
    }

    public int lottosSize() {
        return this.lottoList.size();
    }

    public Map<Integer, Integer> getResult(Lotto winning) {
        for (Lotto lotto : lottoList) {
            int sameNumbers = lotto.getSameNumbers(winning);
            int count = result.getOrDefault(sameNumbers, 0);
            result.put(sameNumbers, count + 1);
        }
        return result;
    }

    public double getProfitRate() {
        return (double) result.get(Lotto.MAX_MATCH_NUMBER) / lottosSize();
    }

    public List<String> toStringList() {
        List<String> stringList = new ArrayList<>();
        for (Lotto lotto : lottoList) {
            stringList.add(lotto.toString());
        }
        return stringList;
    }
}
