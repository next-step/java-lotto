package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class StringCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    void 빈_문자열_또는_null_값을_입력할_경우_0을_반환해야_한다(final String text) {
        assertThat(StringCalculator.calculate(text)).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1"})
    void 숫자_하나를_문자열로_입력할_경우_해당_숫자를_반환한다(final String text) {
        assertThat(StringCalculator.calculate(text)).isSameAs(Integer.parseInt(text));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2"})
    void 숫자_두개를_쉼표구분자로_입력할경우_두숫자의_합을_반환한다(final String text) {
        assertThat(StringCalculator.calculate(text)).isSameAs(3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2:3"})
    void 구분자를_쉼표_이외에_콜론을_사용할_수_있다(final String text) {
        assertThat(StringCalculator.calculate(text)).isSameAs(6);
    }

    @DisplayName(value = "//와 \\n 문자 사이에 커스텀 구분자를 지정할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2;3"})
    void 커스텀_구분자를_지정할_수_있다(final String text) {
        assertThat(StringCalculator.calculate(text)).isSameAs(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2,3:4"})
    void 구분자와_커스텀_구분자를_동시에_사용할_수_있다(final String text) {
        assertThat(StringCalculator.calculate(text)).isSameAs(10);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1,1,2", "5:-2"})
    void 문자열_계산기에_음수를_전달하는_경우_RuntimeException_예외처리를_한다(final String text) {
        assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> StringCalculator.calculate(text));
    }
}
