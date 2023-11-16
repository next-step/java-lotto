package calculator.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    void 입력값이_null이거나_빈공백문자일_경우(String strOperation) {
        assertThatThrownBy(() -> {
            StringCalculator.calc(strOperation);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2 + 3, 5",
            "2 + 3 - 3, 2",
            "2 + 3 - 3 * 4, 8",
            "2 + 3 - 3 * 4 / 2, 4"})
    void 사칙연산_정상(String strOperation, int expected) {
        Number result = StringCalculator.calc(strOperation);
        assertThat(result.value()).isEqualTo(expected);
    }

}
