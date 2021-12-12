package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberTest {

    @Test
    void create_number_with_int() {
        // given
        int intInput = 258;

        // when
        Number number = new Number(intInput);

        // then
        assertThat(number).isEqualTo(new Number(258));
    }

    @Test
    void create_number_with_valid_String() {
        // given
        String stringInput = "258";

        // when
        Number number = new Number(stringInput);

        // then
        assertThat(number).isEqualTo(new Number(258));
    }

    @Test
    void create_number_with_invalid_string() {
        // given
        String stringInput = "not a number";

        // expect
        assertThatThrownBy(() -> new Number(stringInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContainingAll("유효한 숫자 입력이 아닙니다.");
    }

}
