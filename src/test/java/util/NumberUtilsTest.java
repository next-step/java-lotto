package util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class NumberUtilsTest {

    @ParameterizedTest
    @CsvSource(value = {"123:true", "+:false"}, delimiter = ':')
    void is_number(String input, boolean result) {
        boolean isNumber = NumberUtils.isNumber(input);
        assertThat(result).isEqualTo(isNumber);
    }
}