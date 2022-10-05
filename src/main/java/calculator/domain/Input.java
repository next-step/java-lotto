package calculator.domain;

import java.util.Objects;

/**
 * Created by seungwoo.song on 2022-10-05
 */
public class Input {

    private String value;

    public Input(String value) {
        this.value = value;
    }

    public boolean isOperator() {
        return Operator.isOperator(value);
    }

    public int toNumber() {
        return Integer.parseInt(value);
    }

    public Operator toOperator() {
        return Operator.from(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Input input = (Input) o;
        return Objects.equals(value, input.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Input{" +
                "value='" + value + '\'' +
                '}';
    }
}
