package calculator.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class StringCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    void 빈_문자열_또는_null_값을_입력할_경우_0을_반환해야_한다(final String text) {
        StringCalculator calculator = StringCalculator.of(text);
        assertThat(calculator.sumNumbers()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    void 숫자_하나를_문자열로_입력할_경우_해당_숫자를_반환한다(final String text) {
        StringCalculator calculator = StringCalculator.of(text);
        assertThat(calculator.sumNumbers()).isEqualTo(Integer.parseInt(text));
    }

    @Test
    void 숫자_두개를_쉼표구분자로_입력할경우_두숫자의_합을_반환한다() {
        StringCalculator calculator = StringCalculator.of("1,2");
        assertThat(calculator.sumNumbers()).isEqualTo(3);
    }

    @Test
    void 구분자를_쉼표_이외에_콜론을_사용할_수_있다() {
        StringCalculator calculator = StringCalculator.of("1,2:3");
        assertThat(calculator.sumNumbers()).isEqualTo(6);
    }

    @DisplayName(value = "//와 \\n 문자 사이에 커스텀 구분자를 지정할 수 있다.")
    @Test
    void 커스텀_구분자를_지정할_수_있다() {
        StringCalculator calculator = StringCalculator.of("//;\n1;2;3");
        assertThat(calculator.sumNumbers()).isEqualTo(6);
    }

    @Test
    void 구분자와_커스텀_구분자를_동시에_사용할_수_있다() {
        StringCalculator calculator = StringCalculator.of("//;\n1;2,3:4");
        assertThat(calculator.sumNumbers()).isEqualTo(10);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1,1,2", "5:-2"})
    void 문자열_계산기에_음수를_전달하는_경우_RuntimeException_예외처리를_한다(final String text) {
        assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> StringCalculator.of(text));
    }

    @ParameterizedTest
    @ValueSource(strings = {"a,b,c", "가,1,2"})
    void 문자열_계산기에_숫자가_아닌_문자를_전달하는_경우_예외처리를_한다(final String text) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> StringCalculator.of(text));
    }
}
