package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class OperatorTest {
    @ParameterizedTest
    @CsvSource(value = {"'+':12", "'-':8", "'*':20", "'/':5"}, delimiter = ':')
    void 연산자_계산(String input, int expected) {
        Operand left = new Operand(10);
        Operand right = new Operand(2);
        Operator operator = new Operator(input);

        Operand result = operator.calculate(left, right);

        assertThat(result).isEqualTo(new Operand(expected));
    }

    @Test
    void 나눗셈은_정수만_반환() {
        assertThat(new Operator("/").divide(new Operand("10"), new Operand("3"))).isEqualTo(new Operand("3"));
    }

    @Test
    void 산술오류_0으로_나누기() {
        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() -> new Operator("/").divide(new Operand("10"), new Operand("0")))
                .withMessageMatching("/ by zero");
    }

    @Test
    void 나눗셈() {
        assertThat(new Operator("/").divide(new Operand("10"), new Operand("1"))).isEqualTo(new Operand("10"));
    }

    @Test
    void 곱셈() {
        assertThat(new Operator("*").multiply(new Operand("10"), new Operand("1"))).isEqualTo(new Operand("10"));
    }

    @Test
    void 뺼셈() {
        assertThat(new Operator("-").subtract(new Operand("10"), new Operand("1"))).isEqualTo(new Operand("9"));
    }

    @Test
    void 덧셈() {
        assertThat(new Operator("+").add(new Operand("10"), new Operand("1"))).isEqualTo(new Operand("11"));
    }

    @Test
    @DisplayName("사칙 연산 기호 아니면 예외 발생")
    void 사칙_연산_기호_아니면_예외_발생() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Operator("%"));
    }
}