package calculator.util;

import calculator.StringAddCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class NumberUtilsTest {

    @ParameterizedTest
    @ValueSource(strings = { "1", "2", "30"})
    @DisplayName("양의 정수일 때 false 를 반환")
    void positiveNumberReturnFalse(String str){
        boolean result = NumberUtils.isNegativeInt(str);
        assertFalse(result);
    }

    @ParameterizedTest
    @ValueSource(strings = { "-1", "-2", "-30"})
    @DisplayName("음의 정수일 때 true 를 반환")
    void negativeNumberReturnTrue(String str){
        boolean result = NumberUtils.isNegativeInt(str);
        assertTrue(result);
    }
}