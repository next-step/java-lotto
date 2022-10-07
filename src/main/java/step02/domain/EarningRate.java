package step02.domain;

public class EarningRate {

    public static final double TIE_RATIO = 1.0;

    private final float value;

    public EarningRate(float value) {
        this.value = value;
    }

    public EarningRate(long totalAmount, int purchasePrice) {
        this(totalAmount / (float) purchasePrice);
    }

    public float getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EarningRate)) {
            return false;
        }

        EarningRate that = (EarningRate) o;

        return Float.compare(that.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return (value != +0.0f ? Float.floatToIntBits(value) : 0);
    }
}
