package lottery.domain;

public class RateOfReturn {

    private static final double MINIMUM_SURPLUS_LIMIT = 1.0;
    private final double rateOfReturn;

    public RateOfReturn(double rateOfReturn) {
        this.rateOfReturn = rateOfReturn;
    }

    public Boolean isSurplus() {
        if (rateOfReturn == MINIMUM_SURPLUS_LIMIT)
            return null;
        return rateOfReturn > MINIMUM_SURPLUS_LIMIT;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }
}
