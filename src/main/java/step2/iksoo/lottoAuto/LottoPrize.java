package step2.iksoo.lottoAuto;

public enum LottoPrize {
    ZERO(0),
    ONE(0),
    TWO(0),
    THREE(5_000),
    FOUR(50_000),
    FIVE(1_500_000),
    SIX(2_000_000_000);

    private int gradePrize;

    LottoPrize(int gradePrize) {
        this.gradePrize = gradePrize;
    }

    public int getGradePrize() {
        return this.gradePrize;
    }
}
