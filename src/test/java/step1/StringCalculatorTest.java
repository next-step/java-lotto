package step1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringCalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2:2+3*4/2"}, delimiter = ':')
    @DisplayName("공백을 제거하는지 확인한다")
    void 입력문자열_공백제거(String input, String expected) {
        Calculator cal = new Calculator(input);
        cal.deleteSpace();
        Assertions.assertThat(cal.getString()).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2+5"})
    @DisplayName("덧셈 테스트")
    void 덧셈(String input) {
        Calculator cal = new Calculator(input);

        Assertions.assertThat(cal.calculateExpression()).isEqualTo(7);
    }

    @ParameterizedTest
    @ValueSource(strings = {"5-2"})
    @DisplayName("덧셈 테스트")
    void 뺄셈(String input) {
        Calculator cal = new Calculator(input);

        Assertions.assertThat(cal.calculateExpression()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"5*2"})
    @DisplayName("곱셈 테스트")
    void 곱셈(String input) {
        Calculator cal = new Calculator(input);

        Assertions.assertThat(cal.calculateExpression()).isEqualTo(10);
    }


    @ParameterizedTest
    @ValueSource(strings = {"5/2"})
    @DisplayName("나눗셈 테스트")
    void 나눗셈(String input) {
        Calculator cal = new Calculator(input);

        Assertions.assertThat(cal.calculateExpression()).isEqualTo(2);
    }


    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 / 2"})
    @DisplayName("복잡한 연산 테스트")
    void 복잡한_연산(String input) {
        Calculator cal = new Calculator(input);

        Assertions.assertThat(cal.calculateExpression()).isEqualTo(10);
    }

}
