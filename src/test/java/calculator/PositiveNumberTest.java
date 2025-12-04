package calculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PositiveNumberTest {
    @Test
    @DisplayName("문자열로부터 양의 정수를 생성한다")
    void fromString() {
        PositiveNumber number = PositiveNumber.from("10");
        assertThat(number.toInt()).isEqualTo(10);
    }

    @Test
    @DisplayName("음수를 생성하려 하면 IllegalArgumentException을 던진다")
    void negativeNumberNotAllowed() {
        assertThatThrownBy(() -> PositiveNumber.from("-1"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("덧셈을 수행한다")
    void plus() {
        PositiveNumber left = PositiveNumber.from("2");
        PositiveNumber right = PositiveNumber.from("3");

        PositiveNumber result = left.plus(right);

        assertThat(result.toInt()).isEqualTo(5);
    }

    @Test
    @DisplayName("뺄셈을 수행한다")
    void minus() {
        PositiveNumber left = PositiveNumber.from("5");
        PositiveNumber right = PositiveNumber.from("2");

        PositiveNumber result = left.minus(right);

        assertThat(result.toInt()).isEqualTo(3);
    }

    @Test
    @DisplayName("곱셈을 수행한다")
    void multiply() {
        PositiveNumber left = PositiveNumber.from("2");
        PositiveNumber right = PositiveNumber.from("4");

        PositiveNumber result = left.multiply(right);

        assertThat(result.toInt()).isEqualTo(8);
    }

    @Test
    @DisplayName("나눗셈을 수행한다")
    void divide() {
        PositiveNumber left = PositiveNumber.from("8");
        PositiveNumber right = PositiveNumber.from("4");

        PositiveNumber result = left.divide(right);

        assertThat(result.toInt()).isEqualTo(2);
    }
}
