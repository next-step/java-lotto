package domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExpressionTest {

    @Test
    @EmptySource
    void 입력값_빈값_예외발생() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Expression("");
                });
    }

    @Test
    @NullSource
    void 입력값_null값_예외발생() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Expression(null);
                });
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"", " ", "   ", "\t", "\n"})
    void 입력값_null_empty_예외발생(String input) {
        assertTrue(input == null || input.trim().isEmpty());
    }

    @Test
    void 입력값_숫자아닐때_예외발생() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Expression("a");
                });
    }
}

