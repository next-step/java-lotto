package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OperationTest {

    @Test
    @DisplayName("사칙연산이 아닌 연산자가 존재하면 IllegalArgumentException을 throw한다.")
    public void getOperations_ShouldThrowWhenWrongOperators() {
        assertThatThrownBy(() -> Operation.getOperators(List.of("+", "?", "/")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 사칙연산 기호입니다.");
    }

    @Test
    @DisplayName("연산자를 반환한다.")
    public void getOperations() {
        List<String> actual = Operation.getOperators(List.of("6", "+", "3"));

        assertThat(actual).isEqualTo(List.of("+"));
    }

    @Test
    @DisplayName("더하기 연산자가 맞으면 True를 반환한다.")
    public void isAddOperator() {
        boolean actual = Operation.isAddOperator("+");

        assertThat(actual).isEqualTo(true);
    }

    @Test
    @DisplayName("빼기 연산자가 맞으면 True를 반환한다.")
    public void isSubtractOperator() {
        boolean actual = Operation.isSubtractOperator("-");

        assertThat(actual).isEqualTo(true);
    }

    @Test
    @DisplayName("곱하기 연산자가 맞으면 True를 반환한다.")
    public void isMultiplyOperator() {
        boolean actual = Operation.isMultiplyOperator("*");

        assertThat(actual).isEqualTo(true);
    }

    @Test
    @DisplayName("나누기 연산자가 맞으면 True를 반환한다.")
    public void isDivideOperator() {
        boolean actual = Operation.isDivideOperator("/");

        assertThat(actual).isEqualTo(true);
    }
}
