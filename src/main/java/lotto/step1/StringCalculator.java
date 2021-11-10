package lotto.step1;

import java.util.Objects;

public class StringCalculator {

    private String value;

    public StringCalculator(String input) {
        this.value = input;
    }

    public String[] splitDelimiter() {
        return value.split(",|:");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringCalculator that = (StringCalculator) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
