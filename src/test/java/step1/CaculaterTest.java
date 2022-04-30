package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("사칙연산 테스트")
public class CaculaterTest {

    @DisplayName("덧셈 테스트")
    @Test
    void plus() {
        Caculater caculater = new Caculater("3 + 5 + 2");

        assertThat(caculater.result()).isEqualTo(10);
    }
    
    @DisplayName("뺄셈 테스트")
    @Test
    void sub() {
        Caculater caculater = new Caculater("3 - 5 - 2");

        assertThat(caculater.result()).isEqualTo(-4);
    }

    @DisplayName("나눗셈 테스트")
    @Test
    void divide() {
        Caculater caculater = new Caculater("15 / 2 / 3");

        assertThat(caculater.result()).isEqualTo(2);
    }

    @DisplayName("곱셈 테스트")
    @Test
    void multiple() {
        Caculater caculater = new Caculater("3 * 5 * 2");

        assertThat(caculater.result()).isEqualTo(30);
    }

    @DisplayName("계산기 테스트")
    @Test
    void calculator() {
        Caculater caculater = new Caculater("5 * 2 / 3 + 1 * 2 - 1");

        assertThat(caculater.result()).isEqualTo(7);
    }
}
