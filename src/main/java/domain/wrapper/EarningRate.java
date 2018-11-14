package domain.wrapper;

public class EarningRate{
    double earningRate;

    public EarningRate(double earningRate) {
        if(earningRate < 0){
            throw new RuntimeException("음수가 될 수 없습니다.");
        }
        this.earningRate = earningRate;
    }

    public EarningRate(Money price, Money totalRewards) {
        this(totalRewards.divide(price));
    }

    public double getEarningRate() {
        return earningRate;
    }

}
