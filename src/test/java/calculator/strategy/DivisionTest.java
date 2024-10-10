package calculator.strategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class DivisionTest {
    private OperationStrategy operationStrategy;

    @BeforeEach
    void setUp() {
        operationStrategy = Division.getInstance();
    }

    @Test
    void 나눗셈은_정수만_반환() {
        assertThat(operationStrategy.calculate(10, 3)).isEqualTo(3);
    }

    @Test
    void 산술오류_0으로_나누기() {
        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() -> operationStrategy.calculate(1, 0))
                .withMessageMatching("/ by zero");
    }

    @Test
    void 나눗셈_연산() {
        assertThat(operationStrategy.calculate(1, 1)).isEqualTo(1);
    }
}