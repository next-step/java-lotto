package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberTest {

    @Test
    @DisplayName("부 생성자로 객체를 생성한다")
    void shouldCreateUsingConstructor() {
        Number number = new Number("1");
        assertThat(number).isEqualTo(new Number("1"));
    }

    @Test
    @DisplayName("주 생성자로 객체를 생성한다")
    void shouldCreateUsingPrimaryConstructor() {
        Number number = new Number(1);
        assertThat(number).isEqualTo(new Number(1));
    }

    @Test
    @DisplayName("입력값이 음수면 예외를 던진다")
    void shouldThrowWhenNumberIsNegative() {
        assertThatThrownBy(() -> new Number(-1))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("음수는 입력할 수 없습니다.");
    }
}