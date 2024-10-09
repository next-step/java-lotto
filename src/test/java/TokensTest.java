import domain.Tokens;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TokensTest {
    @Test
    @DisplayName("입력이 없는 경우 예외를 던진다.")
    void create_empty() {
        assertThrows(IllegalArgumentException.class, () -> new Tokens(""));
    }

    @Test
    @DisplayName("피연산자가 아닌 경우 예외를 던진다.")
    void validate_invalidOperand() {
        Tokens tokens = new Tokens("1 2 + 3");
        assertThrows(IllegalArgumentException.class, tokens::validate);
    }

    @Test
    @DisplayName("연산자가 아닌 경우 예외를 던진다.")
    void validate_invalidOperator() {
        Tokens tokens = new Tokens("1 + 2 3");
        assertThrows(IllegalArgumentException.class, tokens::validate);
    }

    @Test
    @DisplayName("식이 올바른 경우 예외를 던지지 않는다.")
    void validate_validExpression() {
        Tokens tokens = new Tokens("1 + 2 * 3 / 4 - 5");
        assertDoesNotThrow(tokens::validate);
    }
}
