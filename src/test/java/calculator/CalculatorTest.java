package calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class CalculatorTest {
    @ParameterizedTest
    @NullAndEmptySource
    void 빈_문자열_또는_null_값을_입력한_경우_0을_반환한다(String text) {
        assertThat(Calculator.sum(text)).isZero();
    }

    @ParameterizedTest
    @ValueSource(strings = {"11", "1", "0"})
    void 숫자_하나를_문자열로_입력한_경우_해당_숫자를_반환한다(String text) {
        int value = Integer.parseInt(text);
        assertThat(Calculator.sum(text)).isEqualTo(value);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "$", "일", "//a\n1a이a3"})
    void 숫자_이외의_값을_입력하면_IllegalArgumentException_을_던진다(String text) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Calculator.sum(text));
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "-100", "-99", "//a\n1a2a-3"})
    void 음수_값을_입력하면_IllegalArgumentException_을_던진다(String text) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Calculator.sum(text));
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2=3", "33,56=89"}, delimiter = '=')
    void 숫자_두_개를_컴마_구분자로_입력할_경우_두_숫자의_합을_반환한다(String csv, int expectedSum) {
        assertThat(Calculator.sum(csv)).isEqualTo(expectedSum);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2:3=6", "33,56:11=100"}, delimiter = '=')
    void 구분자로_콤마를_사용할_수_있다(String csv, int expectedSum) {
        assertThat(Calculator.sum(csv)).isEqualTo(expectedSum);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2;3", "//a\n1a2a3", "//&\n1&2&3"})
    void 커스텀_구분자를_지정할_수_있다(String csv) {
        assertThat(Calculator.sum(csv)).isEqualTo(6);
    }
}
