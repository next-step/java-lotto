package lotto.domain;

import lotto.generator.NumberGenerator;
import lotto.generator.RandomNumberGenerator;

import java.util.*;

public class Lottos {

    public static final int LOTTO_PRICE = 1000;

    private NumberGenerator numberGenerator = new RandomNumberGenerator();

    private List<Lotto> lottoList;
    private Map<Integer, Integer> result;

    public Lottos(int amount) {
        this.lottoList = new ArrayList<>();
        this.result = new HashMap<>();

        int n = amount / LOTTO_PRICE;
        for (int i = 0; i < n; i++) {
            this.lottoList.add(new Lotto(numberGenerator));
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
            int sameNumbers = lotto.getSameNumberCount(winning);
            int count = result.getOrDefault(sameNumbers, 0);
            result.put(sameNumbers, count + 1);
        }
        return result;
    }

    public double getProfitRate() {
        return (double) result.get(Lotto.MAX_MATCH_NUMBER) / lottosSize();
    }

    public List<Lotto> getLottoList() {
        return this.lottoList;
    }

}
