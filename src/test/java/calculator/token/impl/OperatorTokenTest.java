package calculator.token.impl;

import calculator.token.Token;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class OperatorTokenTest {

    @DisplayName("OperatorToken의 isOperator는 true를 반환한다.")
    @ParameterizedTest
    @CsvSource({
            "+,2,3,5",
            "-,5,2,3",
            "*,3,4,12",
            "/,10,2,5"
    })
    void apply(String symbol, int left, int right, int expected) {
        OperatorToken operator = new OperatorToken(symbol);
        NumberToken rightToken = new NumberToken(String.valueOf(right));

        assertThat(operator.apply(left, rightToken)).isEqualTo(expected);
    }

    @DisplayName("OperatorToken의 isOperator는 true를 반환한다.")
    @Test
    void isOperator() {
        Token token = new OperatorToken("+");
        assertTrue(token.isOperator());
    }

    @DisplayName("연산자가 아니면 exceotion을 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"11111", "%", "$$"})
    void exception(String symbol) {
        assertThatThrownBy(() -> new OperatorToken(symbol))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
