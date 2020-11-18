package study.calculator.argument;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CustomArgumentTest {


    @Test
    void test_hasCustomArgument_pass() {
        // Given
        String target = "//;\n";

        // When
        boolean result = CustomArgument.hasCustomArgument(target);

        // Then
        assertTrue(result);
    }

    @Test
    void test_hasCustomArgument_fail() {
        // Given
        String target = "///;\n";

        // When
        boolean result = CustomArgument.hasCustomArgument(target);

        // Then
        assertFalse(result);
    }
}