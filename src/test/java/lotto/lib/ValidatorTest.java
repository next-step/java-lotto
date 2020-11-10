package lotto.lib;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class ValidatorTest {

    @ParameterizedTest
    @DisplayName("1부터 45사이의 숫자만 true 이다.")
    @CsvSource(value = {"0$false", "1$true", "45$true", "46$false"}, delimiter = '$')
    void validateLottoRange(int input, boolean expected) {
        assertThat(Validator.validateLottoRange(input))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("숫자가 아닌 String 이면 true 이다.")
    @CsvSource(value = {"0$false", "1$false", "NaN$true", "hello$true"}, delimiter = '$')
    void validateNan(String input, boolean expected) {
        assertThat(Validator.validateNan(input))
                .isEqualTo(expected);
    }
}
