package study.calculator.argument;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

import static org.junit.jupiter.api.Assertions.*;

class BlankArgumentTest {

    @ParameterizedTest
    @NullSource
    void test_nullsource(String source) {

        // When
        boolean result = BlankArgument.isBlankArgument(source);

        // Then
        assertTrue(result);
    }

    @EmptySource
    void test_emptysource(String source) {

        // When
        boolean result = BlankArgument.isBlankArgument(source);

        // Then
        assertTrue(result);
    }

    @Test
    void test_not_null_source() {
        // Given
        String source = "Not Null Value";

        // When
        boolean result = BlankArgument.isBlankArgument(source);

        // Then
        assertFalse(result);
    }
}