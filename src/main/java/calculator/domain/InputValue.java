package calculator.domain;

import javax.print.attribute.standard.MediaSize;
import java.util.Objects;

/**
 * Created by seungwoo.song on 2022-10-04
 */
public class InputValue {

    private final String value;

    public InputValue(String value) {
        this.value = value;
    }

    public boolean isOperator() {
        return Operator.isOperator(value);
    }

    public int toNumber() {
        validateNumber();
        return Integer.parseInt(value);
    }

    public Operator toOperator() {
        validateOperator();
        return Operator.from(value);
    }

    public boolean isZero() {
        validateNumber();
        return Integer.valueOf(value) == 0;
    }

    private void validateOperator() {
        if (!isOperator()) {
            throw new IllegalStateException("숫자는 호출할수 없는 메서드 입니다");
        }
    }

    private void validateNumber() {
        if (isOperator()) {
            throw new IllegalStateException("연산자는 호출할수 없는 메서드 입니다");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InputValue that = (InputValue) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "InputValue{" +
                "value='" + value + '\'' +
                '}';
    }
}
