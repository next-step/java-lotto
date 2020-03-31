package step3.domain;

import java.math.BigDecimal;

public class ResultInfo {
    private BigDecimal investPrice;
    private BigDecimal profitPrice = BigDecimal.ZERO;
    private BigDecimal rate = BigDecimal.ZERO;
    private StringBuffer resultSentence;

    public ResultInfo(int buyLottoTotalPrice) {
        this.investPrice = BigDecimal.valueOf(buyLottoTotalPrice);
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public BigDecimal getInvestPrice() {
        return investPrice;
    }

    public void setInvestPrice(BigDecimal investPrice) {
        this.investPrice = investPrice;
    }


    public StringBuffer getResultSentence() {
        return resultSentence;
    }

    public void setResultSentence(StringBuffer resultSentence) {
        this.resultSentence = resultSentence;
    }

    public BigDecimal getProfitPrice() {
        return profitPrice;
    }

    public void addProfit(BigDecimal multiply) {
        this.profitPrice = this.profitPrice.add(multiply);
        this.rate = this.profitPrice.divide(this.investPrice);
    }
}
