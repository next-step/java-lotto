package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class OperatorTest {
    @ParameterizedTest
    @CsvSource(value = {"'+':12", "'-':8", "'*':20", "'/':5"}, delimiter = ':')
    void 연산자_계산(String input, int expected) {
        Operator operator = new Operator(input);
        assertThat(operator.calculate(10, 2)).isEqualTo(expected);
    }

    @Test
    @DisplayName("사칙 연산 기호 아니면 예외 발생")
    void 사칙_연산_기호_아니면_예외_발생() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Operator("%"));
    }
}