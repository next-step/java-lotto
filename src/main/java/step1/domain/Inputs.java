package step1.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Inputs {
    private final Delimiters delimiters;
    private final Numbers numbers;

    private Inputs(Delimiters delimiters, Numbers numbers) {
        this.delimiters = delimiters;
        this.numbers = numbers;
    }

    public static Inputs createWithDelimiter(String s) {
        List<Number> numbers = new ArrayList<>();

        String delimiter = s.substring(Delimiter.START_DELIMITER.length(), s.indexOf(Delimiter.END_DELIMITER));
        s = s.substring(s.indexOf(Delimiter.END_DELIMITER) + Delimiter.END_DELIMITER.length());

        for (String number : s.split(delimiter)) {
            numbers.add(new Number(Integer.parseInt(number)));
        }

        return new Inputs(Delimiters.createWithDelimiter(new Delimiter(delimiter)), new Numbers(numbers));
    }

    public static Inputs createWithoutDelimiter(String s) {
        Delimiters delimiters = Delimiters.createWithoutDelimiter();
        return new Inputs(Delimiters.createWithoutDelimiter(), delimiters.split(s));
    }

    public Number sum() {
        return numbers.sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inputs inputs = (Inputs) o;
        return Objects.equals(delimiters, inputs.delimiters) &&
                Objects.equals(numbers, inputs.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(delimiters, numbers);
    }
}
