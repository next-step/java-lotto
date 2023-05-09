package lottery;

public enum PnLType {
    PROFIT, LOSS, EVEN;

    public static PnLType fromRevenueAndInvestment(Integer revenue, Integer investment) {
        if (revenue < investment) return LOSS;
        if (revenue.equals(investment)) return EVEN;
        return PROFIT;
    }
}
