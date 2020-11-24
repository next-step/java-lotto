package step1;

import step1.calculator.Inputs;
import step1.calculator.PositiveNumber;

import java.util.Objects;


/**
 * Created By mand2 on 2020-11-16.
 */
public class Calculator {

    private final Inputs inputs;

    private Calculator(InputValue inputValue) {
        this.inputs = Inputs.of(inputValue);
    }

    public static Calculator of(InputValue inputValue) {
        return new Calculator(inputValue);
    }

    public int sumAll() {
        return this.inputs.value().stream()
                .mapToInt(PositiveNumber::value)
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
