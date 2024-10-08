package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AdditionTest {

    @DisplayName("덧셈을 할 수 있다.")
    @Test
    void calculateTest() {
        Addition addition = new Addition();

        assertThat(addition.calculate(2, 3)).isEqualTo(5);
        assertThat(addition.calculate(4, 9)).isEqualTo(13);
    }

    @DisplayName("'+' 연산자인 경우 true 반환한다.")
    @Test
    void supportsTest() {
        Addition addition = new Addition();

        assertThat(addition.supports("+")).isTrue();
        assertThat(addition.supports("-")).isFalse();
        assertThat(addition.supports("/")).isFalse();
        assertThat(addition.supports("*")).isFalse();
    }

}