package step3.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ResultInfo {
    private BigDecimal investPrice;
    private BigDecimal profitPrice = BigDecimal.ZERO;
    private BigDecimal rate = BigDecimal.ZERO;
    private Ranks ranks;

    public ResultInfo(Ranks ranks, int buyLottoTotalPrice) {
        this.investPrice = BigDecimal.valueOf(buyLottoTotalPrice);
        this.ranks = ranks;
        for (int i = 1; i <= RankInformation.matchWinInformationAllCount(); i++) {
            RankInformation rankInformation = RankInformation.matchWinInformationByIndex(i);
            addProfit(rankInformation.getPrice().multiply(BigDecimal.valueOf(match(rankInformation))));
        }
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void addProfit(BigDecimal multiply) {
        this.profitPrice = this.profitPrice.add(multiply);
        this.rate = this.profitPrice.divide(this.investPrice,0, RoundingMode.HALF_EVEN);
    }

    public int match(RankInformation equalsCount) {
        return ranks.match(equalsCount);
    }
}
