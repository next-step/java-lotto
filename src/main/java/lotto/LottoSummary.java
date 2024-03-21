package lotto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;


public class LottoSummary {

    private List<LottoResult> lottoResults;
    private Money payMoney;

    public LottoSummary(List<LottoResult> lottoResults, Money payMoney) {
        this.lottoResults = lottoResults;
        this.payMoney = payMoney;
    }

    public BigDecimal getRateOfReturn() {
        long priceSum = lottoResults.stream()
                .map(lottoResult -> lottoResult.getRank().getWinPrice())
                .mapToLong(BigDecimal::longValue)
                .sum();

        return BigDecimal.valueOf(priceSum).divide(payMoney.getValue(), 2, RoundingMode.DOWN);
    }

    public int getFirstRankCount() {
        return (int) lottoResults.stream()
                .filter(it -> Rank.FIRST == it.getRank())
                .count();
    }

    public int getSecondRankCount() {
        return (int) lottoResults.stream()
                .filter(it -> Rank.SECOND == it.getRank())
                .count();
    }

    public int getThirdRankCount() {
        return (int) lottoResults.stream()
                .filter(it -> Rank.THIRD == it.getRank())
                .count();
    }

    public int getForthRankCount() {
        return (int) lottoResults.stream()
                .filter(it -> Rank.FORTH == it.getRank())
                .count();
    }
}
