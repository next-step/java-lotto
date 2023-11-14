package study.step1;

import org.junit.jupiter.api.Test;
import study.step1.domain.DefaultOperation;
import study.step1.domain.exception.CalculatorException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class DefaultOperationTest {

    @Test
    void 더하기() {
        DefaultOperation operation = new DefaultOperation();
        assertThat(operation.plus(1, 2)).isEqualTo(3);
    }

    @Test
    void 빼기() {
        DefaultOperation operation = new DefaultOperation();
        assertThat(operation.minus(1, 2)).isEqualTo(-1);
    }

    @Test
    void 곱하기() {
        DefaultOperation operation = new DefaultOperation();
        assertThat(operation.times(1, 2)).isEqualTo(2);
    }

    @Test
    void 나누기() {
        DefaultOperation operation = new DefaultOperation();
        assertThat(operation.divide(1, 2)).isEqualTo(0);
        assertThat(operation.divide(2, 2)).isEqualTo(1);
    }

    @Test
    void 나누기오류() {
        DefaultOperation operation = new DefaultOperation();
        assertThatExceptionOfType(CalculatorException.class)
            .isThrownBy(() -> operation.divide(1, 0))
            .withMessage("DivideError: 0으로는 나눌 수 없습니다.");
    }

}
