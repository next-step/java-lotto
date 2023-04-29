package calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberTest {

    @ParameterizedTest(name = "파라미터 덧셈 결과 확인.")
    @CsvSource(value = {"3|3|6", "5|5|10"}, delimiter = '|')
    void 덧셈테스트(String input, String target, int result) {
        Number number = new Number(input);
        number.plus(target);
        assertThat(number.getIntValue()).isEqualTo(result);
    }

    @ParameterizedTest(name = "파라미터 뺄셈 결과 확인.")
    @CsvSource(value = {"3|3|0", "5|2|3"}, delimiter = '|')
    void 뺄셈테스트(String input, String target, int result) {
        Number number = new Number(input);
        number.minus(target);
        assertThat(number.getIntValue()).isEqualTo(result);
    }

    @ParameterizedTest(name = "파라미터 곱셈 결과 확인.")
    @CsvSource(value = {"3|3|9", "5|2|10"}, delimiter = '|')
    void 곱셈테스트(String input, String target, int result) {
        Number number = new Number(input);
        number.multiplication(target);
        assertThat(number.getIntValue()).isEqualTo(result);
    }

    @ParameterizedTest(name = "파라미터 나눗셈 결과 확인.")
    @CsvSource(value = {"3|3|1", "5|2|2"}, delimiter = '|')
    void 나눗셈테스트(String input, String target, int result) {
        Number number = new Number(input);
        number.division(target);
        assertThat(number.getIntValue()).isEqualTo(result);
    }


}
