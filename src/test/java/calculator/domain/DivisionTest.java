package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DivisionTest {

    @DisplayName("나눗셈을 할수 있다.")
    @Test
    void calculateTest() {
        Division division = new Division();

        assertThat(division.calculate(6, 2)).isEqualTo(3);
    }

    @DisplayName("'/' 연산자인 경우 true 반환한다.")
    @Test
    void supportsTest() {
        Division division = new Division();

        assertThat(division.supports("+")).isFalse();
        assertThat(division.supports("-")).isFalse();
        assertThat(division.supports("/")).isTrue();
        assertThat(division.supports("*")).isFalse();
    }
}