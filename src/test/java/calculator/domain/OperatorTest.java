package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import calculator.domain.exception.UnexpectedOperatorException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OperatorTest {

    private Number leftNumber;
    private Number rightNumber;

    @BeforeEach
    void setUp() {
        leftNumber = new Number(4);
        rightNumber = new Number(2);
    }

    @DisplayName("덧셈 기호를 받으면 덧셈을 수행한다.")
    @Test
    void add() {
        Operator operator = Operator.from("+");
        assertThat(operator.apply(leftNumber, rightNumber)).isEqualTo(new Number(6));
    }

    @DisplayName("뺄셈 기호를 받으면 뺄셈을 수행한다.")
    @Test
    void subtract() {
        Operator operator = Operator.from("-");
        assertThat(operator.apply(leftNumber, rightNumber)).isEqualTo(new Number(2));
    }

    @DisplayName("곱셈 기호를 받으면 곱셈을 수행한다.")
    @Test
    void multiply() {
        Operator operator = Operator.from("*");
        assertThat(operator.apply(leftNumber, rightNumber)).isEqualTo(new Number(8));
    }

    @DisplayName("나눗셈 기호를 받으면 나눗셈을 수행한다.")
    @Test
    void divide() {
        Operator operator = Operator.from("/");
        assertThat(operator.apply(leftNumber, rightNumber)).isEqualTo(new Number(2));
    }

    @DisplayName("연산자가 아닌 문자열을 받을 수 없다.")
    @Test
    void unExpectedOperatorException() {
        assertThatExceptionOfType(UnexpectedOperatorException.class)
            .isThrownBy(() -> Operator.from("&"));
    }
}
