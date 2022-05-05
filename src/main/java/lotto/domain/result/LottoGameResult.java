package lotto.domain.result;

import java.util.Objects;

public class LottoGameResult {
    private LottoMatchResults lottoMatchResults;
    private int purchaseAmount;

    public LottoGameResult(int purchaseAmount) {
        this(null, purchaseAmount);
    }

    LottoGameResult(LottoMatchResults lottoMatchResults, int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;

        if (lottoMatchResults == null) {
            this.lottoMatchResults = new LottoMatchResults();
            return;
        }
        this.lottoMatchResults = lottoMatchResults;
    }

    public void addMatchResult(int matchNumber) {
        lottoMatchResults.addMatchNumber(matchNumber);
    }

    int getTotalReward() {
        return lottoMatchResults.getLottoReward();
    }

    double getYield() {
        return (double) getTotalReward() / purchaseAmount;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LottoGameResult lottoGameResult = (LottoGameResult) obj;
        return this.lottoMatchResults.equals(lottoGameResult.lottoMatchResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoMatchResults);
    }

    @Override
    public String toString() {
        double yield = getYield();

        StringBuilder result = new StringBuilder();
        result.append("당첨 통계\n");
        result.append("---------\n");
        result.append(lottoMatchResults);
        result.append("\n");
        result.append("총 수익률은 ").append(yield).append("입니다.");

        if (yield < 1) {
            result.append("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }

        return result.toString();
    }
}
