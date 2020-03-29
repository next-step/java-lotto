package step2.domain;

import java.math.BigDecimal;
import java.util.List;

public class ResultInfo {
    private static BigDecimal investPrice;
    private static BigDecimal profitPrice = BigDecimal.ZERO;
    private static BigDecimal rate = BigDecimal.ZERO;
    private static List<Integer> matchCountList;
    private static StringBuffer resultSentence;

    public static BigDecimal getRate() {
        return rate;
    }

    public static void setRate(BigDecimal rate) {
        ResultInfo.rate = rate;
    }

    public static BigDecimal getInvestPrice() {
        return investPrice;
    }

    public static void setInvestPrice(BigDecimal investPrice) {
        ResultInfo.investPrice = investPrice;
    }


    public static StringBuffer getResultSentence() {
        return resultSentence;
    }

    public static void setResultSentence(StringBuffer resultSentence) {
        ResultInfo.resultSentence = resultSentence;
    }

    public static BigDecimal getProfitPrice() {
        return profitPrice;
    }

    public static void setProfitPrice(BigDecimal profitPrice) {
        ResultInfo.profitPrice = profitPrice;
    }

    public static List<Integer> getMatchCountList() {
        return matchCountList;
    }

    public static void setMatchCountList(List<Integer> matchCountList) {
        ResultInfo.matchCountList = matchCountList;
    }

    public static int match(int number) {
        return (int) matchCountList.stream().filter(d -> number == d).count();
    }

    public void addProfit(BigDecimal multiply) {
        this.profitPrice = this.profitPrice.add(multiply);
    }
}
