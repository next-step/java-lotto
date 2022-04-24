package calculator.operation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DivideOperationTest {

    @Test
    @DisplayName("4와 2 를 넣으면 2를 반환한다.")
    void divide() {
        assertThat(new DivideOperation().operate(4,2)).isEqualTo(2);
    }

    @Test
    @DisplayName("나눗셈을 할때 정수로 나눠지지 않을 경우 IllegalArgumentException 을 반환한다.")
    void divideNotInt() {
        Assertions.assertThatThrownBy(() -> new DivideOperation().operate(3,2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("나눗셈을 할때 0 값으로 나눌 경우 IllegalArgumentException 을 반환한다.")
    void divideZero() {
        Assertions.assertThatThrownBy(() -> new DivideOperation().operate(4,0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}