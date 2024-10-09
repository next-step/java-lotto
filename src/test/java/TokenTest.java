import domain.Token;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TokenTest {
    @Test
    @DisplayName("유효한 피연산자는 예외를 발생시키지 않음")
    void validateOperand_validOperand() {
        Token token = new Token("5");
        assertDoesNotThrow(token::validateOperand);
    }

    @Test
    @DisplayName("유효하지 않은 피연산자는 예외를 발생시킴")
    void validateOperand_invalidOperand() {
        Token token = new Token("+");
        assertThrows(IllegalArgumentException.class, token::validateOperand);
    }

    @Test
    @DisplayName("유효한 연산자는 예외를 발생시키지 않음")
    void validateOperator_validOperator() {
        Token token = new Token("+");
        assertDoesNotThrow(token::validateOperator);
    }

    @Test
    @DisplayName("유효하지 않은 연산자는 예외를 발생시킴")
    void validateOperator_invalidOperator() {
        Token token = new Token("5");
        assertThrows(IllegalArgumentException.class, token::validateOperator);
    }

    @Test
    @DisplayName("피연산자인지 확인하는 함수 테스트")
    void isOperand() {
        Token token = new Token("5");
        assertTrue(token.isOperand());
    }

    @Test
    @DisplayName("연산자인지 확인하는 함수 테스트")
    void isOperator_correctlyIdentified() {
        Token token = new Token("+");
        assertTrue(token.isOperator());
    }
}
