package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {


    @Test
    @DisplayName("숫자 스택과 연산자 스택의 개수가 1개 차이가 나면 true를 반환한다.")
    void 스택_개수_비교() {
        Stack<Integer> numbers = new Stack<>();
        numbers.push(1);
        numbers.push(2);
        Stack<String> operators = new Stack<>();
        operators.push("*");
        assertThat(StringCalculator.getInstance().isValidStackSize(numbers, operators)).isTrue();
    }

    @Test
    @DisplayName("숫자 스택과 연산자 스택의 개수가 1개 차이가 나지 않으면 exception을 발생한다.")
    void 스택_개수_비교_exception() {
        Stack<Integer> numbers = new Stack<>();
        numbers.push(1);
        Stack<String> operators = new Stack<>();
        operators.push("*");
        assertThatThrownBy(() -> StringCalculator.getInstance().isValidStackSize(numbers, operators))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("숫자인 경우 숫자를 반환한다.")
    void 숫자인_경우() {
        assertThat(StringCalculator.getInstance().parseNumber("1")).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자가 아닌 경우 exception을 발생한다.")
    void 숫자_아닌경우() {
        assertThatThrownBy(() -> StringCalculator.getInstance().parseNumber("a"))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("연산자인 경우 true를 반환한다.")
    void 연산자인_경우() {
        assertThat(StringCalculator.getInstance().isOperator("+")).isTrue();
        assertThat(StringCalculator.getInstance().isOperator("*")).isTrue();
        assertThat(StringCalculator.getInstance().isOperator("/")).isTrue();
        assertThat(StringCalculator.getInstance().isOperator("-")).isTrue();
    }

    @Test
    @DisplayName("연산자가 아닌 경우 exception을 발생한다.")
    void 연산자_아닌경우() {
        assertThatThrownBy(() -> StringCalculator.getInstance().isOperator("_"))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("문자열이 비어있는 경우 exception을 발생한다.")
    void 문자열_null_또는_공백() {
        assertThatThrownBy(() -> StringCalculator.getInstance().split(""))
                .isInstanceOf(IllegalStateException.class);
        assertThatThrownBy(() -> StringCalculator.getInstance().split(null))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("문자열을 공백 기준으로 split 한다.")
    void 문자열_split() {
        String[] result = StringCalculator.getInstance().split("3 + 5");
        assertThat(result).hasSize(3);
    }
}
