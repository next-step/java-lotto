package lotto.web;

import java.util.List;
import lotto.domain.RankCount;

public class MatchLottoResponse {
    private List<RankCount> lottoResult;
    private double earningsRate;

    public static class Builder {
        private List<RankCount> lottoResult;
        private double earningsRate;

        public Builder lottoResult(List<RankCount> lottoResult) {
            this.lottoResult = lottoResult;
            return this;
        }

        public Builder earningsRate(double earningsRate) {
            this.earningsRate = earningsRate;
            return this;
        }

        public MatchLottoResponse build() {
            return new MatchLottoResponse(this);
        }
    }

    private MatchLottoResponse(Builder builder) {
        this.lottoResult = builder.lottoResult;
        this.earningsRate = builder.earningsRate;
    }

    public List<RankCount> getLottoResult() {
        return lottoResult;
    }

    public double getEarningsRate() {
        return earningsRate;
    }
}
