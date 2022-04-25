import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
 * 입력 문자열의 숫자와 사칙 연산 사이에는 반드시 빈 공백 문자열이 있다고 가정한다.
 * 나눗셈의 경우 결과 값을 정수로 떨어지는 값으로 한정한다.
 * 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다. [o]
 * 예를 들어 2 + 3 * 4 / 2와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다. [o]
 */
public class CalculatorTest {

    @Test
    void plus_test(){
        assertThat(Calculator.play("2 + 3")).isEqualTo(5);
    }

    @Test
    void minus_test(){
        assertThat(Calculator.play("4 - 3")).isEqualTo(1);
    }

    @Test
    void divide_test(){
        assertThat(Calculator.play("4 / 2")).isEqualTo(2);
    }

    @Test
    void multiply_test(){
        assertThat(Calculator.play("4 * 2")).isEqualTo(8);
    }

    @Test
    void input_null_test(){
        assertThatThrownBy(() -> Calculator.play())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값이 null이거나 빈 공백문자 입니다.");
    }

    @Test
    void input_empty_test(){
        assertThatThrownBy(() -> Calculator.play("   "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값이 null이거나 빈 공백문자 입니다.");
    }

    @Test
    void operator_test(){
        assertThatThrownBy(() -> Calculator.play("2 % 3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("사칙연산 기호가 아닙니다.");
    }

}
