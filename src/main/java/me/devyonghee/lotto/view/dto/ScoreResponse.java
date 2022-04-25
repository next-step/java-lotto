package me.devyonghee.lotto.view.dto;

import me.devyonghee.lotto.model.Rank;
import me.devyonghee.lotto.model.Score;

import java.math.BigDecimal;

public final class ScoreResponse {

    private final RankResponse firstRank;
    private final RankResponse secondRank;
    private final RankResponse thirdRank;
    private final RankResponse fourthRank;
    private final BigDecimal profitRatio;

    private ScoreResponse(RankResponse firstRank, RankResponse secondRank, RankResponse thirdRank, RankResponse fourthRank, BigDecimal profitRatio) {
        this.firstRank = firstRank;
        this.secondRank = secondRank;
        this.thirdRank = thirdRank;
        this.fourthRank = fourthRank;
        this.profitRatio = profitRatio;
    }

    public static ScoreResponse from(Score score) {
        return new ScoreResponse(
                RankResponse.of(Rank.FIRST, score.count(Rank.FIRST)),
                RankResponse.of(Rank.SECOND, score.count(Rank.SECOND)),
                RankResponse.of(Rank.THIRD, score.count(Rank.THIRD)),
                RankResponse.of(Rank.FOURTH, score.count(Rank.FOURTH)),
                score.profitRatio()
        );
    }

    public RankResponse getFirstRank() {
        return firstRank;
    }

    public RankResponse getSecondRank() {
        return secondRank;
    }

    public RankResponse getThirdRank() {
        return thirdRank;
    }

    public RankResponse getFourthRank() {
        return fourthRank;
    }

    public BigDecimal getProfitRatio() {
        return profitRatio;
    }
}
