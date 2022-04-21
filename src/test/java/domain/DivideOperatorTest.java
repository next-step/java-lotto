package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DivideOperatorTest {
    private Operator divideOperator;

    @BeforeEach
    void 생성() {
        divideOperator = DivideOperator.getDivideOperator();
    }

    @ParameterizedTest
    @CsvSource({"1,2,0", "3,2,1", "0,2,0", "7,-1,-7"})
    void 나눗셈_테스트(int num1, int num2, int expected) {
        assertThat(divideOperator.calculate(num1, num2)).isEqualTo(expected);
    }

    @Test
    void 나눗셈_예외_테스트() {
        assertThatThrownBy(() -> {
            divideOperator.calculate(1, 0);
        }).isInstanceOf(ArithmeticException.class);
    }
}