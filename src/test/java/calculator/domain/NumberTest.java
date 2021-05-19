package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberTest {

    @DisplayName("객체 생성 및 동등성 확인")
    @Test
    void equals() {
        // given
        int num = 7;

        // when
        Number number = Number.from(num);
        Number expectedNumber = Number.from(num);

        // then
        assertThat(number).isEqualTo(expectedNumber);
    }

    @DisplayName("음수를 입력하면 예외가 발생한다")
    @Test
    void validate_negative() {
        assertThatThrownBy(() -> Number.from(-1))
                .isInstanceOf(RuntimeException.class);
    }
}
