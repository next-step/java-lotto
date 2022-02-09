package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 10, 11, 223, 2913802})
    void 문자열이_int형으로_잘_반환된다(int number) {
        assertThat(number).isEqualTo(Validator.parseToInt(Integer.toString(number)));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "1a", "sadjkfl", "--1df"})
    void 문자열을_int형으로_반환할_수_없다(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> Validator.parseToInt(input)).withMessage("[ERROR] 숫자만 입력해주세요.");
    }
}
