package lotto.domain;

public class EarningsRate {
    private double earningsRate;
    
    public EarningsRate(final double earningsRate) {
        this.earningsRate = earningsRate;
    }
    
    boolean equalsTo(EarningsRate earningsRate) {
        return this.earningsRate == earningsRate.earningsRate;
    }
    
    @Override
    public String toString() {
        return earningsRate + "";
    }
}
