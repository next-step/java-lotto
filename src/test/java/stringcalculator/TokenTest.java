package stringcalculator;

import stringcalculator.domain.Token;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TokenTest {
    @Test
    @DisplayName("유효한 피연산자는 true를 반환")
    void isOperand_validOperand() {
        Token token = new Token("5");
        assertThat(token.isOperand()).isTrue();
    }

    @Test
    @DisplayName("유효하지 않은 피연산자는 false를 반환")
    void isOperand_invalidOperand() {
        Token token = new Token("+");
        assertThat(token.isOperand()).isFalse();
    }

    @Test
    @DisplayName("유효한 연산자는 true를 반환")
    void isOperator_validOperator () {
        Token token = new Token("+");
        assertThat(token.isOperator()).isTrue();
    }

    @Test
    @DisplayName("유효하지 않은 연산자는 false를 반환")
    void isOperator_invalidOperator() {
        Token token = new Token("5");
        assertThat(token.isOperator()).isFalse();
    }
}
