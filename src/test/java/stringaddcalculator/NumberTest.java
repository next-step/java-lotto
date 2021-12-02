package stringaddcalculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberTest {

    @DisplayName("Number의 생성자에 인자로 전달된 값을 그대로 반환하는지 검증")
    @Test
    void numberConstructorTest() {
        assertThat(new Number(10).getValue()).isEqualTo(10);
    }

    @DisplayName("Number의 생성자에 문자로 전달된 값을 변환하는지 검증")
    @Test
    void stringNumberConstructorTest() {
        assertThat(new Number("10")).isEqualTo(new Number(10));
    }

    @DisplayName("0보다 작은 값으로 Number를 생성하면 예외를 던진다")
    @Test
    void negetiveNumberTest() {
        assertThatThrownBy(() -> new Number(-1)).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("init이 0으로 초기화 되는지 검증")
    @Test
    void initTest() {
        assertThat(Number.init()).isEqualTo(new Number(0));
    }
}
