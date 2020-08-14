package calculator.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CustomSeparator implements Separator {

    private final String delimiter;

    public CustomSeparator(String delimiter) {
        this.delimiter = delimiter;
    }

    @Override
    public List<String> splitByDelimiter(String input) {
        return Arrays.asList(input.split(delimiter));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomSeparator that = (CustomSeparator) o;
        return Objects.equals(delimiter, that.delimiter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(delimiter);
    }

}
