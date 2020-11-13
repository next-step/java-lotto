package lotto.utils;

import lotto.asset.ExceptionConst;
import lotto.exception.NpeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class SplitterTest {


    @ParameterizedTest
    @DisplayName("정상적으로 lotto 가 split 되어야 한다.")
    @CsvSource(value = {"1$[1]", "1,2$[1, 2]", "1 2 12$[1, 2, 12]", "a,,,,,,b$[a, b]", "a,    ,b$[a, b]", " , , , , $[]"}, delimiter = '$')
    void splitLottoStr(String lottoStr, String expected) {
        assertThat(Splitter.splitLottoStr(lottoStr).toString())
                .isEqualTo(expected);
    }

    @Test
    @DisplayName("null 을 split 하려 하면 NpeException 이 발생한다.")
    void splitLottoStr() {
        assertThatExceptionOfType(NpeException.class)
                .isThrownBy(() -> Splitter.splitLottoStr(null))
                .withMessage(ExceptionConst.NPE_MSG);
    }
}
