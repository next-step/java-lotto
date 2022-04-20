package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MinusOperatorTest {
    private Operator minusOperator;

    @BeforeEach
    void 생성() {
        minusOperator = new MinusOperator();
    }

    @ParameterizedTest
    @CsvSource({"1,2,-1", "3,2,1", "0,2,-2", "-1,7,-8"})
    void 뺄셈_테스트(int num1, int num2, int expected) {
        assertThat(minusOperator.calculate(num1, num2)).isEqualTo(expected);
    }
}