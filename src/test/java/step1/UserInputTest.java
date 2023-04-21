package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserInputTest {

    @DisplayName("정상적인 연산식 입력 테스트")
    @Test
    void of() {
        assertThatNoException().isThrownBy(() -> UserInput.of("2 + 3 * 4 / 1"));
    }

    @DisplayName("띄어쓰기 구분 없는 입력 테스트")
    @Test
    void noEmptySpace() {
        assertThatThrownBy(() -> UserInput.of("2+3*4/1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("허용되지 않는 연산자 입력 테스트")
    @Test
    void notAllowedOperator() {
        assertThatThrownBy(() -> UserInput.of("2 + 3 * 4 | 1"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
