package lotto.response;

import lotto.domain.LottoRank;
import lotto.domain.LottoResults;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoResultResponse {

    private final List<LottoRankResponse> lottoRankResponses;
    private final double profitRate;

    public LottoResultResponse(LottoResults lottoResults) {
        this.lottoRankResponses = Arrays.stream(LottoRank.values())
                .filter(rank -> rank != LottoRank.NONE)
                .map(rank -> new LottoRankResponse(
                        rank,
                        lottoResults.getLottoResults()
                                .getOrDefault(rank, LottoResults.DEFAULT_COUNT)))
                .collect(Collectors.toList());
        Collections.reverse(this.lottoRankResponses);
        this.profitRate = lottoResults.getProfitRate().getProfitRate();
    }

    public List<LottoRankResponse> getLottoRankResponses() {
        return lottoRankResponses;
    }

    public double getProfitRate() {
        return profitRate;
    }
}
