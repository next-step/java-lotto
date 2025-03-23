package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OperatorTokenTest {
    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "*", "/"})
    void valid_input(String input) {
        assertThat(new OperatorToken(input)).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "~", "!"})
    void invalid_input(String input) {
        assertThatThrownBy(() -> new OperatorToken(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "5,+,3,8",
            "5,-,3,2",
            "5,*,3,15",
            "5,/,3,1"
    })
    void apply_operator(int left, String operator, int right, int expected) {
        OperatorToken operatorToken = new OperatorToken(operator);
        assertThat(operatorToken.apply(left, right)).isEqualTo(expected);
    }
}
