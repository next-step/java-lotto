package lotto.utils;

import lotto.asset.ExceptionConst;
import lotto.exception.BadNumOfLottoNoException;
import lotto.exception.LottoRangeException;
import lotto.exception.NanException;
import lotto.exception.NpeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoParserTest {


    @ParameterizedTest
    @DisplayName("정상적으로 lotto 가 split 되어야 한다.")
    @CsvSource(value = {"1$[1]", "1,2$[1, 2]", "1 2 12$[1, 2, 12]", "a,,,,,,b$[a, b]", "a,    ,b$[a, b]", " , , , , $[]"}, delimiter = '$')
    void splitLottoStr(String lottoStr, String expected) {
        assertThat(LottoParser.splitLottoStr(lottoStr).toString())
                .isEqualTo(expected);
    }

    @Test
    @DisplayName("null 을 split 하려 하면 NpeException 이 발생한다.")
    void splitLottoStr() {
        assertThatExceptionOfType(NpeException.class)
                .isThrownBy(() -> LottoParser.splitLottoStr(null))
                .withMessage(ExceptionConst.NPE_MSG);
    }

    @ParameterizedTest
    @DisplayName("정상적으로 lottoStr 가 parse 되어야 한다.")
    @CsvSource(value = {"1, 2, 3, 4, 5, 6$[1, 2, 3, 4, 5, 6]", "8, 21, 23, 41, 42, 43$[8, 21, 23, 41, 42, 43]", "3, 5, 11, 16, 32, 38$[3, 5, 11, 16, 32, 38]", "7, 11, 16, 35, 36, 44$[7, 11, 16, 35, 36, 44]"}, delimiter = '$')
    void parseLottoStr(String lottoStr, String expected) {
        assertThat(LottoParser.parseLottoStr(lottoStr).toString())
                .isEqualTo(expected);
    }


    @ParameterizedTest
    @DisplayName("숫자가 아닌 로또 번호가 입력되면 NanException 이 발생한다.")
    @ValueSource(strings = {"a, b, 3, 4, 5, 6", "8, 21, 2c, 4d, 42, 43", "3, 5, 11, 16, e2, f8", "7, g1, 16, 35, h6, 44"})
    void parseLottoStr_nan(String lottoStr) {
        assertThatExceptionOfType(NanException.class)
                .isThrownBy(() -> LottoParser.parseLottoStr(lottoStr))
                .withMessage(ExceptionConst.NAN_MSG);
    }

    @ParameterizedTest
    @DisplayName("1 부터 45가 아닌 로또 번호가 입력되면 LottoRangeException 이 발생한다.")
    @ValueSource(strings = {"0, 1, 2, 3, 4, 5", "1, 2, 3, 4, 5, 46"})
    void parseLottoStr_range(String lottoStr) {
        assertThatExceptionOfType(LottoRangeException.class)
                .isThrownBy(() -> LottoParser.parseLottoStr(lottoStr))
                .withMessage(ExceptionConst.LOTTO_RANGE_MSG);
    }

    @ParameterizedTest
    @DisplayName("로또 번호가 6개 입력되지 않으면, BadNumOfLottoNoException 이 발생한다.")
    @ValueSource(strings = {"a, b, 4, 5, 6", "8, 21, 42, 43", "e2, f8", ""})
    void parseLottoStr_badNumOfLottoNo(String lottoStr) {
        assertThatExceptionOfType(BadNumOfLottoNoException.class)
                .isThrownBy(() -> LottoParser.parseLottoStr(lottoStr))
                .withMessage(ExceptionConst.BAD_NUM_OF_LOTTO_NO_MSG);
    }
}
