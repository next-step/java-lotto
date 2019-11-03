package calculator;

import jdk.internal.util.xml.impl.Input;

import java.util.List;
import java.util.Objects;

public class StringAddCalculator {
    private Inputs inputs;
    public StringAddCalculator() {
    }

    public int add(String input) {

        // 검증된 String wrapping
        this.inputs = new Inputs(input);
        return sum(inputs);
    }

    private int sum(Inputs inputs) {
        return inputs.addInput();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringAddCalculator that = (StringAddCalculator) o;
        return Objects.equals(inputs, that.inputs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inputs);
    }

}
