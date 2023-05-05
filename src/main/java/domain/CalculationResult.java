package domain;

import java.util.Objects;

public class CalculationResult {

    private int result;

    public CalculationResult(int result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "결과는 = " + result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CalculationResult that = (CalculationResult) o;
        return result == that.result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }
}
