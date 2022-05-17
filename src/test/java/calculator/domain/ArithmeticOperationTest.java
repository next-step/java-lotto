package calculator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ArithmeticOperationTest {

    ArithmeticOperation operation;

    @Test
    void 덧셈() {
        operation = new AddOperation();
        assertThat(operation.compute(1, 2)).isEqualTo(3);
    }

    @Test
    void 뺄셈() {
        operation = new SubstractOperation();
        assertThat(operation.compute(1, 2)).isEqualTo(-1);
    }

    @Test
    void 곱셈() {
        operation = new MultiplyOperation();
        assertThat(operation.compute(1, 2)).isEqualTo(2);
    }

    @Test
    void 나눗셈() {
        operation = new DivideOperation();
        assertThat(operation.compute(1, 2)).isEqualTo(0);
    }

}