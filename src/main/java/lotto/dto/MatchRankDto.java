package lotto.dto;

import lotto.domain.LottoGame;
import lotto.domain.constant.Rank;

import java.util.ArrayList;
import java.util.List;

public class MatchRankDto {

    private final List<LottoRankDto> lottoRankDtos;
    private final double benefitRate;

    private MatchRankDto(List<LottoRankDto> lottoRankDtos, double benefitRate) {
        this.lottoRankDtos = lottoRankDtos;
        this.benefitRate = benefitRate;
    }

    public static MatchRankDto from(LottoGame lottoGame) {
        List<LottoRankDto> matchRankDtos = new ArrayList<>();
        for (Rank rank : Rank.values()) {
            int matchCount = lottoGame.matchRankCount(rank);
            matchRankDtos.add(new LottoRankDto(rank, matchCount));
        }
        return new MatchRankDto(matchRankDtos, lottoGame.calculateBenefitRate());
    }

    public List<LottoRankDto> getLottoRankDtos() {
        return lottoRankDtos;
    }

    public double getBenefitRate() {
        return benefitRate;
    }
}
