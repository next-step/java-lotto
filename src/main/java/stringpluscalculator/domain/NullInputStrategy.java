package stringpluscalculator.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class NullInputStrategy implements InputStrategy {

    private final String input;

    NullInputStrategy(final String input) {
        this.input = input;
    }

    @Override
    public List<Integer> parse() {
        return Collections.emptyList();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NullInputStrategy that = (NullInputStrategy) o;
        return Objects.equals(input, that.input);
    }

    @Override
    public int hashCode() {
        return Objects.hash(input);
    }
}
