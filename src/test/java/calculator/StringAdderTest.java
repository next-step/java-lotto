package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Created by yusik on 2019/11/02.
 */
public class StringAdderTest {

    @DisplayName("빈 문자")
    @Test
    void emptyString() {
        // given
        StringAdder adder = new StringAdder();

        // when
        int result = adder.sum("");

        // then
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("단일 문자")
    @ParameterizedTest
    @CsvSource(value = {"0=0", "100=100"}, delimiter = '=')
    void SingleNumber(String input, int expected) {
        // given
        StringAdder adder = new StringAdder();

        // when
        int result = adder.sum(input);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("콤마(,) 구분자 정상 입력")
    @ParameterizedTest
    @CsvSource(value = {"1,2=3", "10,20,30=60"}, delimiter = '=')
    void comma(String input, int expected) {
        // given
        StringAdder adder = new StringAdder();

        // when
        int result = adder.sum(input);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("콜론(:) 구분자 정상 입력")
    @ParameterizedTest
    @CsvSource(value = {"1:2=3", "10:20:30=60"}, delimiter = '=')
    void colon(String input, int expected) {
        // given
        StringAdder adder = new StringAdder();

        // when
        int result = adder.sum(input);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("멀티 구분자 정상 입력")
    @ParameterizedTest
    @CsvSource(value = {"1:2,3=6", "10,20:30=60"}, delimiter = '=')
    void commaAndColon(String input, int expected) {
        // given
        StringAdder adder = new StringAdder();

        // when
        int result = adder.sum(input);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("커스텀 구분자")
    @ParameterizedTest
    @CsvSource(value = {"//;\n1;2;3=6"}, delimiter = '=')
    void customDelimiter(String input, int expected) {
        // given
        StringAdder adder = new StringAdder();

        // when
        int result = adder.sum(input);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("음수 입력")
    @ParameterizedTest
    @CsvSource(value = {"-1;2;3=6", "-1;z;3=6"}, delimiter = '=')
    void negativeInteger(String input) {
        // given
        StringAdder adder = new StringAdder();

        // when
        // then
        assertThatThrownBy(() -> {
            adder.sum(input);
        }).isInstanceOf(RuntimeException.class);

    }
}
