package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private final Map<LottoRank, Integer> result;

    public LottoResult(List<LottoRank> lottoRanks) {
        result = new EnumMap<>(LottoRank.class);
        Arrays.stream(LottoRank.values()).forEach(
            lottoRank -> result.put(lottoRank, 0)
        );
        makeResult(lottoRanks);
    }

    public void makeResult(final List<LottoRank> lottoRanks) {
        lottoRanks.forEach(lottoRank -> result.put(lottoRank, result.get(lottoRank) + 1));
    }

    public Map<LottoRank, Integer> getResult() {
        return result;
    }

    public double getProfitRate(int price) {
        return (double) calculateWinningPrice() / price;
    }

    public int calculateWinningPrice() {
        int sum = 0;
        for (Map.Entry<LottoRank, Integer> entry : result.entrySet()) {
            sum += entry.getValue() * entry.getKey().getPrice();
        }
        return sum;
    }

}
