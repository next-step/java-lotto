package dev.dahye.lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ConvertUtilsTest {
    @ParameterizedTest(name = "입력 값 = {0}")
    @NullAndEmptySource
    @DisplayName("입력 값이 null이거나 빈 값인 경우 IllegalArguments exception throw")
    void winningNumbers_must_not_be_null_or_empty(String winningNumbers) {
        assertThatThrownBy(() -> ConvertUtils.convertStringToIntegerList(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바르지 않은 입력 값입니다.");
    }

    @ParameterizedTest(name = "입력 값 = {0}")
    @ValueSource(strings = {"가", "&"})
    @DisplayName("입력 값이 숫자가 아닌 경우 IllegalArguments exception throw")
    void winningNumbers_invalid_number(String invalidNumber) {
        assertThatThrownBy(() -> ConvertUtils.convertStringToIntegerList(invalidNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력 값은 숫자만 입력 가능합니다.");
    }
}