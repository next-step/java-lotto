package stringcalculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NumberTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null 이거나 빈 문자열이 입력되면 에러")
    void null_or_empty(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Number(input));
    }

    @Test
    @DisplayName("공백 문자열이 입력되면 에러")
    void blank() {
        String input = "  ";
        assertThatIllegalArgumentException().isThrownBy(() -> new Number(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "&", "`", "?", "😀"})
    @DisplayName("숫자가 아닌 문자가 입력되면 에러")
    void not_number(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Number(input));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 123, -123, 0, -1})
    @DisplayName("숫자가 입력되면 정상")
    void normal_number(int input) {
        Number number = new Number(String.valueOf(input));
        assertThat(number.getValue()).isEqualTo(input);
    }
}