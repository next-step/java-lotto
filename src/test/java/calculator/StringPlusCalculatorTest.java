package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class StringPlusCalculatorTest {

    private StringPlusCalculator stringPlusCalculator;

    @BeforeEach
    void setUp() {
        stringPlusCalculator = new StringPlusCalculator();
    }

    @CsvSource(value = {"1:2:3=6", "1,2:3=6", "3,4,7=14"}, delimiter = '=')
    @ParameterizedTest
    @DisplayName("기본 구분자(, :) 를 갖는 문자열을 계산한다.")
    void 문자열_덧셈_기본_구분자_테스트(String input, int expected) {
        int result = stringPlusCalculator.calculate(input);
        assertThat(result).isEqualTo(expected);
    }

    @ValueSource(strings = {"1:2-3=6", "1!2:3=6", "3*4,7=14"})
    @ParameterizedTest
    @DisplayName("기본 구분자(, :) 이외 구분자를 갖는 문자열은 예외가 발생한다.")
    void 문자열_덧셈_다른_구분자_예외_테스트(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> stringPlusCalculator.calculate(input));
    }

    @CsvSource(value = {"1=1", "2=2", "3=3"}, delimiter = '=')
    @ParameterizedTest
    @DisplayName("숫자 하나만 존재하는 input 자열을 계산한다.")
    void 문자열_덧셈_숫자_하나_테스트(String input, int expected) {
        int result = stringPlusCalculator.calculate(input);
        assertThat(result).isEqualTo(expected);
    }

    @CsvSource(value = {"//;\n1;2;3=6", "//,\n1,2,3=6", "///\n1/2/3=6"}, delimiter = '=')
    @ParameterizedTest
    @DisplayName("커스텀 구분자를 계산한다.")
    void 커스텀_구분_테스트(String input, int expected) {
        int result = stringPlusCalculator.calculate(input);
        assertThat(result).isEqualTo(expected);
    }

    @ValueSource(strings = {"//;\n1;2;3", "-1,2", "-2", "2:-2"})
    @ParameterizedTest
    @DisplayName("음수 값이 존재할 경우 예외가 발생한다.")
    void 음수값_구분_예외테스트(String input) {
        assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> stringPlusCalculator.calculate(input));
    }
}
