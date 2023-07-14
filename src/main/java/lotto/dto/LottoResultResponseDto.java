package lotto.dto;

import lotto.domain.LottoRank;
import lotto.domain.LottoResults;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoResultResponseDto {

    private final List<LottoRankDto> lottoRankDtos;
    private final double profitRate;

    public LottoResultResponseDto(LottoResults lottoResults) {
        this.lottoRankDtos = Arrays.stream(LottoRank.values())
                .filter(rank -> rank != LottoRank.NONE)
                .map(rank -> new LottoRankDto(
                        rank,
                        lottoResults.getLottoResults()
                                .getOrDefault(rank, LottoResults.DEFAULT_COUNT)))
                .collect(Collectors.toList());
        Collections.reverse(this.lottoRankDtos);
        this.profitRate = lottoResults.getProfitRate().getProfitRate();
    }

    public List<LottoRankDto> getLottoRankDtos() {
        return lottoRankDtos;
    }

    public double getProfitRate() {
        return profitRate;
    }
}
