package calculator.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringUtilsTest {

    @DisplayName("isNumber 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3:true", "-1:true", "000:true", "ㅁ:false", "O:false", "0.0:false"}, delimiter = ':')
    void isNumber_test(String input, boolean result) {
        assertThat(StringUtils.isNumber(input)).isEqualTo(result);
    }

    @DisplayName("isNumber - null 입력 시, 예외 발생 테스트")
    @Test
    void isNumber_throw_exception_test() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> StringUtils.isNumber(null))
                .withMessageContaining("입력값이 숫자가 아닙니다.");
    }
}
