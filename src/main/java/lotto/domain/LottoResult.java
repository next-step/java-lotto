package lotto.domain;

import java.util.Map;
import java.util.Objects;

public class LottoResult {
    private static final int MATCHES_COUNT = 1;
    private final Map<Ranking, Integer> lottoResultMap;

    public LottoResult() {
        this.lottoResultMap = Ranking.valueMap();
    }

    public Map<Ranking, Integer> getLottoResultMap() {
        return lottoResultMap;
    }

    public void updateCount(Ranking ranking) {
        this.lottoResultMap.put(ranking, this.lottoResultMap.get(ranking) + MATCHES_COUNT);
    }

    public double findProfitRate(Money money) {
        long totalMoney = 0;
        for (Ranking ranking : lottoResultMap.keySet()) {
            totalMoney += lottoResultMap.get(ranking) * ranking.getPrizeMoney();
        }
        return (double) totalMoney / money.getPurchasePrice();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoResult that = (LottoResult) o;
        return Objects.equals(lottoResultMap, that.lottoResultMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoResultMap);
    }
}
