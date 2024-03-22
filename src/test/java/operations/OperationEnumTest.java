package operations;

import domain.operations.Number;
import domain.operations.enums.OperationEnum;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OperationEnumTest {

    @DisplayName("연산자 찾기")
    @Test
    void calculate() {
        Assertions.assertThat(OperationEnum.PLUS.calculate(1, 3)).isEqualTo(4);
        Assertions.assertThat(OperationEnum.MINUS.calculate(1, 3)).isEqualTo(-2);
        Assertions.assertThat(OperationEnum.DIVISION.calculate(1, 3)).isEqualTo(0);
        Assertions.assertThat(OperationEnum.DIVISION.calculate(4, 3)).isEqualTo(1);
        Assertions.assertThat(OperationEnum.MULTIPLICATION.calculate(4, 3)).isEqualTo(12);
    }

    @DisplayName("")
    @Test
    void calculateWithOperation() {
        Assertions.assertThat(OperationEnum.calculate("+", new Number(1), new Number(3))).isEqualTo(4);
        Assertions.assertThat(OperationEnum.calculate("-", new Number(1), new Number(3))).isEqualTo(-2);
        Assertions.assertThat(OperationEnum.calculate("*", new Number(1), new Number(3))).isEqualTo(3);
        Assertions.assertThat(OperationEnum.calculate("/", new Number(1), new Number(3))).isEqualTo(0);
    }
}
