package calculator.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
public class OperatorTest {
    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "*", "/"})
    void create(String value) {
        Operator operator = new Operator(value);
        assertThat(operator.getOperator()).isEqualTo(value);
    }

    @ParameterizedTest
    @ValueSource(strings = {"3", "^", "s", "~"})
    void invaild_value(String value) {
        assertThatThrownBy(() -> {
            Operator operator = new Operator(value);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
