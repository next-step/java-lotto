package lottery;

public enum PnLType {
    PROFIT, LOSS, EVEN;

    public static PnLType fromRevenueAndInvestment(Natural revenue, Natural investment) {
        if (revenue.value() < investment.value()) return LOSS;
        if (revenue.equals(investment)) return EVEN;
        return PROFIT;
    }
}
