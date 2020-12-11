package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StringCalculatorTest {

    @DisplayName("기본구분자 계산")
    @ParameterizedTest
    @CsvSource(value = {"1,2:3/6", "10:3/13"}, delimiter = '/')
    void add(String value, int expected) {
        //when
        int actual = StringCalculator.add(value);

        //then
        assertEquals(expected, actual);
    }

    @DisplayName("사용자구분자 계산")
    @Test
    void add() {
        //given
        String value = "//;\n1;2;4";
        int expected = 7;

        //when
        int actual = StringCalculator.add(value);

        //then
        assertEquals(expected, actual);
    }

    @DisplayName("빈값 계산")
    @Test
    void add_emptyValue() {
        //given
        String value = "";
        int expected = 0;

        //when
        int actual = StringCalculator.add(value);

        //then
        assertEquals(expected, actual);
    }
}
