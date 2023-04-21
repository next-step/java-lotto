package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ExpressionTest {

    @DisplayName("연산식에서 순서대로 연산 가져오는 지 확인")
    @Test
    void getOperation() {
        Expression expression = Expression.from(List.of("1", "2", "3"), List.of("*", "+"));

        Operation operation = expression.getOperation();
        assertThat(operation.getOperator()).isEqualTo("*");
        assertThat(operation.getOperand1()).isEqualTo("1");
        assertThat(operation.getOperand2()).isEqualTo("2");
    }
}
