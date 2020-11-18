package step1.calculator;

import step1.InputValue;
import step1.StringSplitter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created By mand2 on 2020-11-16.
 */
public class Inputs {

    private final List<PositiveNumber> positiveNumbers;

    private Inputs(List<PositiveNumber> positiveNumbers) {
        this.positiveNumbers = positiveNumbers;
    }

    public static Inputs of(InputValue inputValue) {
        return Inputs.of(inputValue.getInput());
    }

    public static Inputs of(String input) {
        // String to [] 로..!
        String[] strInputs = StringSplitter.split(input);

        List<PositiveNumber> inputs = Arrays.stream(strInputs)
                .map(s -> PositiveNumber.of(s))
                .collect(Collectors.toList());

        return new Inputs(inputs);
    }

    public List<PositiveNumber> value() {
        return Collections.unmodifiableList(this.positiveNumbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inputs inputs = (Inputs) o;
        return Objects.equals(positiveNumbers, inputs.positiveNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(positiveNumbers);
    }
}
