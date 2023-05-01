package calculator;

import calculator.Operation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OperationTest {
    @Test
    @DisplayName("덧셈 테스트")
    void plusTest() {
        assertThat(Operation.plus(1,2)).isEqualTo(3);
    }

    @Test
    @DisplayName("뺄셈 테스트")
    void minusTest() {
        assertThat(Operation.minus(3,2)).isEqualTo(1);
    }

    @Test
    @DisplayName("곱셈 테스트")
    void multipleTest() {
        assertThat(Operation.multiple(3,4)).isEqualTo(12);
    }

    @Test
    @DisplayName("나눗셈 테스트")
    void divisionTest() {
        assertThat(Operation.division(12,3)).isEqualTo(4);
    }
}
