package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OperationTest {

    @Test
    @DisplayName("사칙연산이 아닌 연산자가 존재하면 IllegalArgumentException을 throw한다.")
    public void validateOperators() {
        assertThatThrownBy(() -> Operation.validateOperators("1 ? 3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 사칙연산 기호입니다.");
    }

    @Test
    @DisplayName("사칙연산이 맞으면 true를 반환한다.")
    public void isArithmeticOperation_ShouldReturnTrueWhenArithmeticOperation() {
        boolean actual = Operation.isArithmeticOperation("+");

        assertThat(actual).isEqualTo(true);
    }

    @Test
    @DisplayName("사칙연산이 아니면 false를 반환한다.")
    public void isArithmeticOperation_ShouldReturnFalseWhenWrongArithmeticOperation() {
        boolean actual = Operation.isArithmeticOperation("?");

        assertThat(actual).isEqualTo(false);
    }

    @Test
    @DisplayName("연산자를 파싱해 반환한다.")
    public void parseOperations() {
        List<String> actual = Operation.parseOperations(List.of("6", "+", "3"));

        assertThat(actual).isEqualTo(List.of("+"));
    }
}
