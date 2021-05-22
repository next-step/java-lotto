package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumbersTest {

    @DisplayName("숫자인 문자를 입력하면 합계가 반환된다")
    @Test
    void sum() {
        // given
        Numbers numbers = Numbers.from(Values.init("1,2,3"));

        // when
        int result = numbers.sum();

        // then
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("숫자가 아닌 문자를 입력하면 예외가 발생한다")
    @Test
    void validate_number() {
        assertThatThrownBy(() -> Numbers.from(Values.init("1,2,삼,one")))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("only number are available");
    }
}
