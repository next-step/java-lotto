package step2.model;

import java.util.List;

public class LottoPrizes {

    private final List<LottoPrize> lottoPrizes;
    private final double payOffRatio;

    private LottoPrizes(List<LottoPrize> lottoPrizes, double payOffRatio) {
        this.lottoPrizes = lottoPrizes;
        this.payOffRatio = payOffRatio;
    }

    public static LottoPrizes of(List<LottoPrize> lottoPrizes, double payOffRatio) {
        return new LottoPrizes(lottoPrizes, payOffRatio);
    }

    public List<LottoPrize> getLottoPrizes() {
        return lottoPrizes;
    }

    public double getPayOffRatio() {
        return this.payOffRatio;
    }
}
