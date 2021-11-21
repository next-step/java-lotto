package utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class StringUtilsTest {

    @NullAndEmptySource
    @ParameterizedTest(name = "빈값또는 null 입력시 true를 반환해야한다.")
    void isNullOrEmptyTrueTest(String input) {
        assertThat(StringUtils.isNullOrEmpty(input)).isTrue();
    }

    @ValueSource(strings = "word")
    @ParameterizedTest(name = "빈값또는 null 입력시 false를 반환해야한다.")
    void isNullOrEmptyFalseTest(String input) {
        assertThat(StringUtils.isNullOrEmpty(input)).isFalse();
    }


    @ValueSource(strings = {"1"})
    @ParameterizedTest(name = "[{argumentsWithNames}] 0이상의 수가 입력된 경우 양수값이 반환된다.")
    void parsePositiveNumberTest(String input) {

        assertThat(StringUtils.parsePositiveNumber(input)).isEqualTo(1);
    }

    @ValueSource(strings = {"-1", "asd"})
    @ParameterizedTest(name = "[{argumentsWithNames}] 음수 또는 숫자 값이 아닌경우, IllegalArgumentException이 발생한다.")
    void parsePositiveNumberExceptionTest(String input) {

        assertThatIllegalArgumentException().isThrownBy(
            () -> StringUtils.parsePositiveNumber(input));
    }
}