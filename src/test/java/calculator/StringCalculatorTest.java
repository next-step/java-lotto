package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class StringCalculatorTest {

    StringCalculator calculator = new StringCalculator();

    @DisplayName("계산기 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1 + 2 * 3:9", "4 - 7 / 3:-1"}, delimiter = ':')
    void test0(String input, String result){
        Assertions.assertThat(calculator.calculate(input)).isEqualTo(Integer.parseInt(result));
    }

    @DisplayName("입력이 null이거나 빈 문자열인 경우 throw IllegalArgumentException")
    @ParameterizedTest
    @NullAndEmptySource
    void test1(String value){
        Assertions.assertThatThrownBy(() -> calculator.calculate(value)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("첫 파싱결과는 피연산자여야한다")
    @ParameterizedTest
    @ValueSource(strings = {"+ 2 - 3 - 5", "* 6 + 10 / 2 * 6"})
    void test2(String value){
        Assertions.assertThatThrownBy(() -> calculator.calculate(value)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("파싱결과는 홀수여야 한다")
    @ParameterizedTest
    @ValueSource(strings = {"1 + 2 - 3 -", "5 * 6 + 10 / 10 *"})
    void test3(String value){
        Assertions.assertThatThrownBy(() -> calculator.calculate(value)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("파싱결과는 피연산자와 연산자가 번갈아 나와야 한다")
    @ParameterizedTest
    @ValueSource(strings = {"1 + - 2 3 -", "5 4 6 + 10 / 10 *"})
    void test4(String value){
        Assertions.assertThatThrownBy(() -> calculator.calculate(value)).isInstanceOf(IllegalArgumentException.class);
    }

}