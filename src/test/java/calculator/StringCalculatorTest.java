package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringCalculatorTest {

    @DisplayName("문자열 식 입력 - 기본 구분자 문자열")
    @ParameterizedTest
    @ValueSource(strings = {"", "1,2:3"})
    void create(String value) {
        //when
        StringCalculator stringCalculator = new StringCalculator(value);

        //then
        assertThat(stringCalculator).isNotNull();
    }

    @DisplayName("문자열 식 입력 - 사용자 구분자 문자열")
    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2", "//!\n1!2"})
    void create_custom_delimiter(String value) {
        //when
        StringCalculator stringCalculator = new StringCalculator(value);

        //then
        assertThat(stringCalculator).isNotNull();
    }

    @DisplayName("기본구분자 계산")
    @ParameterizedTest
    @CsvSource(value = {"1,2:3/6", "10:3/13"}, delimiter = '/')
    void add(String value, int expected) {
        //given
        StringCalculator stringCalculator = new StringCalculator(value);

        //when
        int actual = stringCalculator.add();

        //then
        assertEquals(expected, actual);
    }

    @DisplayName("사용자구분자 계산")
    @Test
    void add() {
        //given
        String value = "//;\n1;2;4";
        int expected = 7;
        StringCalculator stringCalculator = new StringCalculator(value);

        //when
        int actual = stringCalculator.add();

        //then
        assertEquals(expected, actual);
    }

    @DisplayName("빈값 계산")
    @Test
    void add_emptyValue() {
        //given
        String value = "";
        int expected = 0;
        StringCalculator stringCalculator = new StringCalculator(value);

        //when
        int actual = stringCalculator.add();

        //then
        assertEquals(expected, actual);
    }
}
