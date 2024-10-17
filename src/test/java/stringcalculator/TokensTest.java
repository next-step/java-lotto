package stringcalculator;

import stringcalculator.domain.Tokens;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TokensTest {
    @Test
    @DisplayName("입력이 null인 경우 예외를 던진다.")
    void create_null() {
        assertThrows(IllegalArgumentException.class, () -> new Tokens(null));
    }

    @Test
    @DisplayName("입력이 없는 경우 예외를 던진다.")
    void create_empty() {
        assertThrows(IllegalArgumentException.class, () -> new Tokens(""));
    }

    @Test
    @DisplayName("피연산자가 아닌 경우 예외를 던진다.")
    void validate_invalidOperand() {
        assertThrows(IllegalArgumentException.class, () -> new Tokens("1 2 + 3"));
    }

    @Test
    @DisplayName("연산자가 아닌 경우 예외를 던진다.")
    void validate_invalidOperator() {
        assertThrows(IllegalArgumentException.class, () -> new Tokens("1 + 2 3"));
    }

    @Test
    @DisplayName("식이 올바른 경우 예외를 던지지 않는다.")
    void validate_validExpression() {
        assertDoesNotThrow(() -> new Tokens("1 + 2 * 3 / 4 - 5"));
    }
}
