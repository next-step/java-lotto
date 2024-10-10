package calculator.dto;

import java.util.Objects;

public class CalculationResult {
    public final String value;

    public CalculationResult(final String value) {
        this.value = value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CalculationResult that = (CalculationResult) o;
        return Objects.equals(value, that.value);
    }
}
