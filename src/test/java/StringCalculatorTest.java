import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {

    private StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환")
    @ParameterizedTest
    @NullAndEmptySource
    void emptyOrNull(final String value) {
        assertThat(calculator.calculate(value)).isZero();
    }

    @DisplayName("커스텀 구분자 형식의 문자열 중 숫자값을 빈 문자열로 입력한 경우 0을 반환")
    @Test
    void customDelimiterValueIsEmpty() {
        assertThat(calculator.calculate("//:\n")).isZero();
    }

    @DisplayName(value = "문자열 계산기에 음수를 전달하는 경우 RuntimeException 발생")
    @Test
    void negative() {
        assertThatThrownBy(() -> calculator.calculate("-1"))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName(value = "숫자 이외의 값을 전달할 경우 RuntimeException 발생")
    @ParameterizedTest
    @ValueSource(strings = { "a,1", "//\\;\n1;a;3", "b", "*", "1:c,2", "1,^" })
    void notNumeric(final String value) {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> calculator.calculate(value));
    }

    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환")
    @ParameterizedTest
    @ValueSource(strings = { "1", "100000" })
    void oneNumber(final String value) {
        assertThat(calculator.calculate(value)).isEqualTo(Integer.parseInt(value));
    }

    @DisplayName("숫자 두 개를 콤마(,) 구분자로 입력할 경우 두 숫자의 합을 반환")
    @ParameterizedTest
    @CsvSource(value = { "1,2=3", "10,100=110", "0,0=0" }, delimiter = '=')
    void twoNumbers(final String value, final int expected) {
        assertThat(calculator.calculate(value)).isEqualTo(expected);
    }

    @DisplayName("구분자를 콤마(,) 이외에 콜론(:) 사용 가능")
    @ParameterizedTest
    @MethodSource
    void defaultDelimiterSum(final String value, final int expected) {
        assertThat(calculator.calculate(value)).isEqualTo(expected);
    }

    private static Stream<Arguments> defaultDelimiterSum() {
        return Stream.of(
                Arguments.of("1,2,3", 6),
                Arguments.of("100,101:102", 303),
                Arguments.of("2:3:10000", 10005),
                Arguments.of("1:2,3:4,5", 15)
        );
    }

    @DisplayName("//와 \n 문자 사이에 커스텀 구분자를 지정 가능")
    @ParameterizedTest
    @MethodSource
    void customDelimiterSum(final String value, final int expected) {
        assertThat(calculator.calculate(value)).isEqualTo(expected);
    }

    private static Stream<Arguments> customDelimiterSum() {
        return Stream.of(
                // ; : & @ # %   = - ! ] }
                Arguments.of("//;\n0", 0),
                Arguments.of("//;\n10000", 10000),
                Arguments.of("//;\n1;2;3", 6),
                Arguments.of("//;\n1;2;;", 3),
                Arguments.of("//;\n;", 0)
        );
    }

    @DisplayName("//와 \n 문자 사이에 정규표현식 meta char 를 커스텀 구분자로 지정 가능")
    @ParameterizedTest
    @MethodSource(value = "metaCharDelimiterCase")
    void customMetaCharDelimiterSum(final String value, final int expected) {
        assertThat(calculator.calculate(value)).isEqualTo(expected);
    }

    private static Stream<Arguments> metaCharDelimiterCase() {
        return Stream.of(
                // |
                Arguments.of("//|\n999", 999),
                Arguments.of("//|\n1|2|3", 6),
                // .
                Arguments.of("//.\n1", 1),
                Arguments.of("//.\n10011.2.3", 10016),
                // ^ $
                Arguments.of("//^\n200^22", 222),
                // * + { [ ? ( )
                Arguments.of("//*\n1*2*3*", 6)
        );
    }
}
