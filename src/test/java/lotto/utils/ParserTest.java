package lotto.utils;

import lotto.exception.NanException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ParserTest {

    @ParameterizedTest
    @DisplayName("정상적으로 lottoStr 가 parse 되어야 한다.")
    @CsvSource(value = {"1, 2, 3, 4, 5, 6$[1, 2, 3, 4, 5, 6]", "8, 21, 23, 41, 42, 43$[8, 21, 23, 41, 42, 43]", "3, 5, 11, 16, 32, 38$[3, 5, 11, 16, 32, 38]", "7, 11, 16, 35, 36, 44$[7, 11, 16, 35, 36, 44]"}, delimiter = '$')
    void parseLottoStr(String lottoStr, String expected) {
        assertThat(Parser.parseLottoStr(lottoStr).toString())
                .isEqualTo(expected);
    }


    @ParameterizedTest
    @DisplayName("숫자가 아닌 로또 번호가 입력되면 NanException 이 발생한다.")
    @ValueSource(strings = {"a, b, 3, 4, 5, 6", "8, 21, 2c, 4d, 42, 43", "3, 5, 11, 16, e2, f8", "7, g1, 16, 35, h6, 44"})
    void parseLottoStr_nan(String lottoStr) {
        assertThatExceptionOfType(NanException.class)
                .isThrownBy(() -> Parser.parseLottoStr(lottoStr));
    }
}
