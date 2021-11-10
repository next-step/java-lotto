package lotto.step1;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class StringCalculator {

    private List<String> values;

    public StringCalculator(String input) {
        String[] array = splitDelimiter(input);
        this.values = Arrays.asList(array);
    }

    public List<String> getValues() {
        return values;
    }

    public int add() {
        return values.stream()
                .mapToInt(Integer::valueOf)
                .sum();
    }

    private String[] splitDelimiter(String input) {
        return input.split("[,:]");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringCalculator that = (StringCalculator) o;
        return Objects.equals(values, that.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }

}
