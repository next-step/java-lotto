package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberTokenTest {
    @Test
    void validate_test() {
        assertThat(new NumberToken("1")).isNotNull();
    }

    @Test
    void invalidate_test() {
        assertThatThrownBy(() -> new NumberToken("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "5,+,3,8",
            "5,-,3,2",
            "5,*,3,15",
            "5,/,3,1"
    })
    void operate(String left, String operator, String right, int expected) {
        NumberToken leftToken = new NumberToken(left);
        NumberToken rightToken = new NumberToken(right);
        NumberToken expectedToken = new NumberToken(expected);
        OperatorToken operatorToken = new OperatorToken(operator);
        assertThat(leftToken.operate(rightToken, operatorToken)).isEqualTo(expectedToken);
    }
}
