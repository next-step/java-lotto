package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("문자열 덧셈 계산기 테스트")
public class CalculatorTest {

    @DisplayName("입력 값이 null 이거나 빈값이면 0을 반환한다.")
    @NullAndEmptySource
    @ParameterizedTest
    void should_return_zero_when_input_is_null_or_empty(String input) {
        //arrange, act
        int result = Calculator.calculate(input);

        //assert
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("숫자 이외의 값이나 음수가 전달될 경우 RuntimeException 예외가 발생한다.")
    @ValueSource(strings = {"-1,1", "1,a", "1,a,-1"})
    @ParameterizedTest
    void must_throw_exception_not_natural_number(String input) {
        //arrange, act, assert
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> Calculator.calculate(input));
    }

    @DisplayName("기본구분자로 분리하여 값들을 모두 더한 후 반환한다.")
    @CsvSource(value = {"1,2,3^6", "1:2:3^6"}, delimiter = '^')
    @ParameterizedTest
    void should_return_add_value_using_default_tokenizer(String input, int expectedValue) {
        //arrange, act, assert
        assertThat(Calculator.calculate(input)).isEqualTo(expectedValue);
    }

    @DisplayName("커스텀구분자로 분리하여 값들을 모두 더한 후 반환한다.")
    @Test
    void should_return_add_value_using_custom_tokenizer() {
        //arrange
        String input = "//-\n1-2-3";
        int expect = 6;

        //act, assert
        assertThat(Calculator.calculate(input)).isEqualTo(expect);
    }

}
