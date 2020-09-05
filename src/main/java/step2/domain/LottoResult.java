package step2.domain;

import java.util.Map;

public class LottoResult {
    private Map<LottoMatchingCount, Long> resultMap;

    public LottoResult(Map<LottoMatchingCount, Long> map) {
        this.resultMap = map;
    }

    public static LottoResult of(Map<LottoMatchingCount, Long> lottoResultByRank) {
        if (lottoResultByRank == null) {
            throw new IllegalArgumentException("");
        }
        return new LottoResult(lottoResultByRank);
    }

    public Map<LottoMatchingCount, Long> getResultMap() {
        return resultMap;
    }

    public Long getRankCount(LottoMatchingCount matchingCount) {
        return resultMap.getOrDefault(matchingCount, 0L);
    }

    public double calculateWinningRate(String lottoMoney) {
        double buyCount = resultMap.values()
                .stream()
                .reduce(0L, Long::sum);

        double totalPrize = resultMap.keySet()
                .stream()
                .map(lottoRank -> lottoRank.getMoney() * resultMap.get(lottoRank))
                .reduce(0L, Long::sum);

        return totalPrize / Double.parseDouble(lottoMoney);
    }
}
