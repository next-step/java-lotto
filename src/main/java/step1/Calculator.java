package step1;

import step1.calculator.Inputs;

import java.util.Objects;


/**
 * Created By mand2 on 2020-11-16.
 */
public class Calculator {

    private final Inputs inputs;

    private Calculator(String input) {
        this.inputs = Inputs.of(input);
    }

    private Calculator(InputValue inputValue) {
        this.inputs = Inputs.of(inputValue);
    }

    public static Calculator of(InputValue inputValue) {
        return new Calculator(inputValue);
    }

    public static Calculator of(String input) {
        return new Calculator(input);
    }

    public int sumAll() {
        return this.inputs.value().stream()
                .mapToInt(Integer::valueOf)
                .sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Calculator that = (Calculator) o;
        return Objects.equals(inputs, that.inputs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inputs);
    }


}
