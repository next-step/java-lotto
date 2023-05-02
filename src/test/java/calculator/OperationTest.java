package calculator;

import calculator.Operation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OperationTest {
    Operation operation;
    @Test
    @DisplayName("덧셈 테스트")
    void plusTest() {
        operation = new Plus();
        assertThat(operation.calculate(1,2)).isEqualTo(3);
    }

    @Test
    @DisplayName("뺄셈 테스트")
    void minusTest() {
        operation = new Minus();
        assertThat(operation.calculate(4,2)).isEqualTo(2);
    }

    @Test
    @DisplayName("곱셈 테스트")
    void multipleTest() {
        operation = new Multiple();
        assertThat(operation.calculate(4,3)).isEqualTo(12);
    }

    @Test
    @DisplayName("나눗셈 테스트")
    void divisionTest() {
        operation = new Division();
        assertThat(operation.calculate(12,3)).isEqualTo(4);
    }
}
