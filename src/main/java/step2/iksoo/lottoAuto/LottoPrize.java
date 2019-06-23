package step2.iksoo.lottoAuto;

public enum LottoPrize {
    zero(0),
    one(0),
    two(0),
    three(5000),
    four(50000),
    five(1500000),
    six(2000000000);

    private int gradePrize;

    LottoPrize(int gradePrize) {
        this.gradePrize = gradePrize;
    }

    public int getGradePrize() {
        return this.gradePrize;
    }

    public int sumCurrentPrizeAmout(int numberOfWons) {
        return this.gradePrize * numberOfWons;
    }
}
