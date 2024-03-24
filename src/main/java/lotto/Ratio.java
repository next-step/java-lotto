package lotto;

import java.util.Objects;

public class Ratio {

    private final double ratio;

    public Ratio(double ratio) {
        this.ratio = ratio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ratio)) return false;
        Ratio ratio1 = (Ratio) o;
        return Double.compare(ratio, ratio1.ratio) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ratio);
    }

    @Override
    public String toString() {
        return String.valueOf(ratio);
    }
}
