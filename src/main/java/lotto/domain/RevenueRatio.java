package lotto.domain;

public enum RevenueRatio {
    LOSS(0.99,"손해"),
    SAME(1.00,"본전"),
    PROFIT(1.01,"이익");

    private double ratio;
    private String name;

    private RevenueRatio(double ratio, String name) {
        this.ratio = ratio;
        this.name = name;
    }

    public double getRatio() {
        return ratio;
    }

    public String getName() {
        return name;
    }

    public static RevenueRatio valueOf(double ratio) {
        if (RevenueRatio.LOSS.getRatio() >= ratio) {
            return RevenueRatio.LOSS;
        }
        if (RevenueRatio.SAME.getRatio() == ratio) {
            return RevenueRatio.SAME;
        }
        if (RevenueRatio.PROFIT.getRatio() <= ratio) {
            return RevenueRatio.PROFIT;
        }
        return null;
    }
}
