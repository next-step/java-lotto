package lottery.domain;

public class RateOfReturn {

    private static final double MINIMUM_SURPLUS_LIMIT = 1.0;

    private final double rateOfReturn;

    private RateOfReturn(double rateOfReturn) {
        this.rateOfReturn = rateOfReturn;
    }

    public static RateOfReturn from(double rateOfReturn) {
        return new RateOfReturn(rateOfReturn);
    }

    public boolean isSurplus() {
        return rateOfReturn >= MINIMUM_SURPLUS_LIMIT;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }
}
