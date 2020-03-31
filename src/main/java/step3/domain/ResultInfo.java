package step3.domain;

import java.math.BigDecimal;

public class ResultInfo {
    private BigDecimal investPrice;
    private BigDecimal profitPrice = BigDecimal.ZERO;
    private BigDecimal rate = BigDecimal.ZERO;

    public ResultInfo(int buyLottoTotalPrice) {
        this.investPrice = BigDecimal.valueOf(buyLottoTotalPrice);
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void addProfit(BigDecimal multiply) {
        this.profitPrice = this.profitPrice.add(multiply);
        this.rate = this.profitPrice.divide(this.investPrice);
    }
}
