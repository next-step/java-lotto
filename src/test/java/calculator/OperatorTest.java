package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class OperatorTest {
    @Test
    @DisplayName("연산자 찾기")
    void find() {
        Operator operator = Operator.find("+");
        Assertions.assertThat(operator).isEqualTo(Operator.ADDITION);
        Operator operator2 = Operator.find("-");
        Assertions.assertThat(operator2).isEqualTo(Operator.SUBTRACTION);
        Operator operator3 = Operator.find("*");
        Assertions.assertThat(operator3).isEqualTo(Operator.MULTIPLICATION);
        Operator operator4 = Operator.find("/");
        Assertions.assertThat(operator4).isEqualTo(Operator.DIVISION);
    }

    @Test
    @DisplayName("연산자가 유효하지 않은 경우 예외 발생")
    void findInvalidOperator() {
        Assertions.assertThatThrownBy(() -> Operator.find("!"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("!은 유효하지 않은 연산자 입니다.");
    }

    @Test
    @DisplayName("사칙연산 기본 테스트")
    void apply() {
        Operator operator = Operator.find("+");
        Assertions.assertThat(operator.apply(BigDecimal.valueOf(2), BigDecimal.valueOf(3))).isEqualTo(BigDecimal.valueOf(5));
        Operator operator2 = Operator.find("-");
        Assertions.assertThat(operator2.apply(BigDecimal.valueOf(2), BigDecimal.valueOf(3))).isEqualTo(BigDecimal.valueOf(-1));
        Operator operator3 = Operator.find("*");
        Assertions.assertThat(operator3.apply(BigDecimal.valueOf(2), BigDecimal.valueOf(3))).isEqualTo(BigDecimal.valueOf(6));
        Operator operator4 = Operator.find("/");
        Assertions.assertThat(operator4.apply(BigDecimal.valueOf(2), BigDecimal.valueOf(4))).isEqualTo(BigDecimal.valueOf(0.5));
    }

    @Test
    @DisplayName("0으로 나누는 경우 예외 발생")
    void divide() {
        Operator operator = Operator.find("/");
        Assertions.assertThatThrownBy(() -> operator.apply(BigDecimal.valueOf(2), BigDecimal.valueOf(0)))
                .isInstanceOf(ArithmeticException.class);
    }
}
