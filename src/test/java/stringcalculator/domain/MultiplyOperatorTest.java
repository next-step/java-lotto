package stringcalculator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MultiplyOperatorTest {
    private Operator multiplyOperator;

    @BeforeEach
    void 생성() {
        multiplyOperator = MultiplyOperator.getMultiplyOperator();
    }

    @ParameterizedTest
    @CsvSource({"1,2,2", "3,2,6", "0,2,0", "-1,7,-7"})
    void 곱셈_테스트(int num1, int num2, int expected) {
        assertThat(multiplyOperator.calculate(num1, num2)).isEqualTo(expected);
    }
}