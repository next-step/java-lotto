package step1.enumeration;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step1.exception.DivideByZeroException;
import step1.model.NumberCalculation;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static step1.enumeration.Operator.getOperator;

class OperatorTest {
    @ParameterizedTest
    @CsvSource(value = {"+:2:6", "-:1:3", "*:2:8", "/:4:1"}, delimiter = ':')
    public void 숫자_연산_검증(String op, String num, int expected) {
        NumberCalculation number = new NumberCalculation(4);
        Operator.getOperator(op).calculate(number, num);

        assertThat(number).isEqualTo(new NumberCalculation(expected));
    }

    @Test
    public void 숫자를_0으로_나누는_검증() {
        NumberCalculation number = new NumberCalculation(4);

        assertThatThrownBy(() -> Operator.getOperator("/").calculate(number, "0"))
                .isInstanceOf(DivideByZeroException.class);
    }

    @Test
    public void 유효하지_않는_연산자_입력_검증() {
        assertThatThrownBy(() -> getOperator("&"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}