package lotto.util;

import lotto.exception.InputValueException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringUtilsTest {

    @DisplayName("숫자 문자열이 아닌 경우 숫자로 형변환 할 수 없다.")
    @Test
    void canNotToIntIfNotNumber() {
        assertThatThrownBy(() -> StringUtils.toInt("a"))
                .isInstanceOf(InputValueException.class);
    }

    @DisplayName("숫자 문자열은 숫자로 형변환 할 수 있다.")
    @ParameterizedTest
    @CsvSource(value = { "1,1", "2,2", "3,3", "4,4", "5,5" })
    void canToInt(String stringInt, int result) {
        assertThat(StringUtils.toInt(stringInt)).isEqualTo(result);
    }

}
