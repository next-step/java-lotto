package step1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static step1.Operator.*;

public class OperatorTest {

    @Test
    void 덧셈_테스트() {
        int a = 5, b = 6;
        Integer calculate = Operator.of("+").calculate(a, b);
        assertThat(calculate).isEqualTo(a + b);
    }

    @Test
    void 뺄셈_테스트() {
        int a = 6, b = 5;
        assertThat(Operator.of("-").calculate(a, b)).isEqualTo(a - b);
    }

    @Test
    @DisplayName("곱셈 테스트")
    void 곱셈_테스트() {
        int a = 6, b = 5;
        assertThat(Operator.of("*").calculate(a, b)).isEqualTo(a * b);
    }

    @Test
    @DisplayName("나눗셈 테스트")
    void 나눗셈_테스트() {
        int a = 6, b = 2;
        assertThat(Operator.of("/").calculate(a, b)).isEqualTo(a / b);
    }

    @Test
    @DisplayName("나눗셈이 정수로 떨어지지 않으면 예외를 발생시킨다.")
    void 나눗셈이_정수로_나눠지지않으면_예외를_던진다() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Operator.of("/").calculate(5, 2);
        });
    }

    @Test
    @DisplayName("4칙연산이 아니면 예외를 발생시킨다.")
    void 사칙_연산이_아니면_예외를_발생시킨다() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Operator.of("$");
        }).withMessage("사칙연산 기호가 아닙니다.");
    }


    @Test
    @DisplayName("사칙 연산을 모두 포함하는 연산")
    void 사칙_연산_모두_포함하는_연산() {
        String input = "2 + 3 * 4 / 2";
        assertThat(new OperatorService().operate(input)).isEqualTo(10);
    }
}
