package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class NumberTest {

    @Test
    @DisplayName("Number 객체 생성")
    void create_number_test() {
        // given
        String text = "7";

        // when
        Number number = Number.of(text);

        // then
        assertThat(number).isEqualTo(Number.of(text));
    }

    @Test
    @DisplayName("음수가 포함된 문자열 입력시 예외 발생")
    void negative_input_check_test() {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
            String text = "-1";
            Number number = Number.of(text);
        }).withMessageMatching("문자열에 음수값이 포함되어 있습니다.");
    }

    @Test
    @DisplayName("숫자가 아닌 값 입력시 Runtime 에러")
    void input_not_int_check_test() {
        String text = "*";

        assertThatThrownBy(() -> Number.of(text))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("input string: \"*\"");
    }

}
