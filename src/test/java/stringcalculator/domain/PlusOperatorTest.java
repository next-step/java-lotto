package stringcalculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PlusOperatorTest {
    private Operator plusOperator;

    @BeforeEach
    void 생성() {
        plusOperator = PlusOperator.getPlusOperator();
    }

    @ParameterizedTest
    @CsvSource({"1,2,3", "3,2,5", "0,2,2", "-1,7,6"})
    void 덧셈_테스트(int num1, int num2, int expected) {
        assertThat(plusOperator.calculate(num1, num2)).isEqualTo(expected);
    }
}