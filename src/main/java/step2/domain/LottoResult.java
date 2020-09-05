package step2.domain;

import java.util.Map;

public class LottoResult {
    private Map<LottoRank, Long> resultMap;

    public LottoResult(Map<LottoRank, Long> map) {
        this.resultMap = map;
    }

    public static LottoResult of(Map<LottoRank, Long> lottoResultByRank) {
        if (lottoResultByRank == null) {
            throw new IllegalArgumentException("");
        }
        return new LottoResult(lottoResultByRank);
    }

    public Map<LottoRank, Long> getResultMap() {
        return resultMap;
    }

    public Long getRankCount(LottoRank matchingCount) {
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
