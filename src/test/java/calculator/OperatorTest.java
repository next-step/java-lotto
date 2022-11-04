package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OperatorTest {

    @Test
    @DisplayName("사칙연산이 아닌 연산자가 존재하면 IllegalArgumentException을 throw한다.")
    public void getOperators_ShouldThrowWhenWrongOperators() {
        assertThatThrownBy(() -> Operator.parseOperators(List.of("+", "?", "/")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 사칙연산 기호입니다.");
    }

    @Test
    @DisplayName("연산자를 반환한다.")
    public void getOperators() {
        List<String> actual = Operator.parseOperators(List.of("6", "+", "3"));

        assertThat(actual).isEqualTo(List.of("+"));
    }
}
