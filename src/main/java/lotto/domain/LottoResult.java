package lotto.domain;

import lotto.LottoRank;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LottoResult {

    private final int MATCH_COUNT_BOUND = 2;
    private final int INCREASE_COUNT = 1;
    private final int DEFAULT_COUNT = 0;

    private final Map<LottoRank, Integer> lottoResult;

    private LottoResult(CollectionOflLottoNumbers collectionOflLottoNumbers, LottoNumbers winningLottoNumbers) {
        lottoResult = new HashMap<>();

        for (LottoNumbers lottoNumbers : collectionOflLottoNumbers.getCollectionOfLottoNumbers()) {
            int matchCount = lottoNumbers.getMatchCount(winningLottoNumbers);

            setRankEnumByMatchCount(matchCount);
        }
    }

    public static LottoResult of(CollectionOflLottoNumbers collectionOflLottoNumbers, LottoNumbers winningLottoNumbers) {
        return new LottoResult(collectionOflLottoNumbers, winningLottoNumbers);
    }

    private void setRankEnumByMatchCount(int matchCount) {
        if (matchCount > MATCH_COUNT_BOUND) {
            LottoRank key = LottoRank.valueOf(matchCount);
            lottoResult.put(key, lottoResult.getOrDefault(key, DEFAULT_COUNT) + INCREASE_COUNT);
        }
    }

    public Map<LottoRank, Integer> getLottoResult() {

        return Collections.unmodifiableMap(lottoResult);
    }

    public double calculateProfitRate(double purchaseAmount) {

        double totalAmount = lottoResult.keySet().stream()
                .mapToDouble(key -> lottoResult.getOrDefault(key, 0) * key.getPrice())
                .sum();

        double profitRate = totalAmount / purchaseAmount;

        return profitRate;
    }
}
