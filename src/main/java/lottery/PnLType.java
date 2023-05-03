package lottery;

public enum PnLType {
    PROFIT, LOSS, EVEN;

    public static PnLType fromProfitAndTotalInvestment(Integer profit, Integer totalInvestment) {
        if (profit < totalInvestment) return LOSS;
        if (profit.equals(totalInvestment)) return EVEN;
        return PROFIT;
    }
}
