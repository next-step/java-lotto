package step2.domain;

import java.math.BigDecimal;
import java.util.List;

public class ResultInfo {
    private BigDecimal investPrice;
    private BigDecimal profitPrice = BigDecimal.ZERO;
    private BigDecimal rate = BigDecimal.ZERO;
    private List<Integer> matchCountList;
    private StringBuffer resultSentence;

    public ResultInfo(BigDecimal investPrice, List<Integer> matchCountList) {
        this.investPrice = investPrice;
        this.matchCountList = matchCountList;
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

    public List<Integer> getMatchCountList() {
        return matchCountList;
    }

    public int match(int number) {
        return (int) matchCountList.stream()
                .filter(d -> number == d)
                .count();
    }

    public void addProfit(BigDecimal multiply) {
        this.profitPrice = this.profitPrice.add(multiply);
        this.rate = this.profitPrice.divide(this.investPrice);
    }
}
