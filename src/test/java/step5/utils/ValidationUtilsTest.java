package step5.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;


class ValidationUtilsTest {
    @DisplayName("입력받은 당첨번호 null 체크")
    @ParameterizedTest
    @NullAndEmptySource
    void isNullCheck(String input) {
        assertThat(ValidationUtils.isNullCheck(input)).isFalse();
    }

    @DisplayName("입력받은 문자열이 쉼표로 구분되는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3 4,5.6", "1:2:3:4:5,6", "1 2 3 4 5,8"})
    void validWinningNumbersComma(String input) {
        boolean result = ValidationUtils.validWinningNumbersComma(input);
        assertThat(result).isFalse();
    }

    @DisplayName("입력받은 size가 6자리인지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"7", "0", "3"})
    void validWinningNumbersDigit(int size) {
        boolean result = ValidationUtils.validWinningNumbersDigit(size);
        assertThat(result).isFalse();
    }
}