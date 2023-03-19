import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import letterCalculator.StringCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {

    private StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @DisplayName(value = "구분자를 쉼표(,) 이외에 콜론(:)을 사용할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2:3"})
    void colons(final String text) {
        assertThat(calculator.add(text)).isSameAs(6);
    }

    @DisplayName(value = "문자열에서 숫자를 분리한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2:3"})
    void seperate(final String text) {
        assertThat(calculator.getSplit(text)).isEqualTo(text.split(",|:"));
    }

    @DisplayName(value = "빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void emptyOrNull(final String text) {
        assertThat(calculator.add(text)).isZero();
    }

    @DisplayName("구분자 외의 숫자를 더할수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3"})
    void addNumber(final String text) {
        assertThat(calculator.add(text)).isEqualTo(6);
    }

    @DisplayName("음수는 사용할수 없다. ")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "1,2:-3"})
    void negativeNumberCheckTest(final String input) {
        assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> calculator.add(input));
    }

    @DisplayName(value = "숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1"})
    void oneNumber(final String text) {
        assertThat(calculator.add(text)).isSameAs(Integer.parseInt(text));
    }

    @DisplayName(value = "숫자 두개를 쉼표(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2"})
    void twoNumbers(final String text) {
        assertThat(calculator.add(text)).isSameAs(3);
    }

    @DisplayName(value = "//와 \\n 문자 사이에 커스텀 구분자를 지정할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2;3"})
    void customDelimiter(final String text) {
        final StringCalculator calculator = new StringCalculator();
        assertThat(calculator.add(text)).isSameAs(6);
    }

    @DisplayName(value = "구분자 외의 문자열은 숫자만 허용한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,a"})
    void inputNumber(final String text) {
        assertThatExceptionOfType(NumberFormatException.class)
            .isThrownBy(() -> calculator.add(text));
    }
}
