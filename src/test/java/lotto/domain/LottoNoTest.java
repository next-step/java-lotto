package lotto.domain;

import lotto.asset.ExceptionConst;
import lotto.exception.LottoNoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoNoTest {
    @ParameterizedTest
    @DisplayName("1부터 45가 아닌 숫자로 LottoNo을 만들면, Exception 이 발생한다.")
    @CsvSource(value = {"0$true", "1$false", "45$false", "46$true"}, delimiter = '$')
    public void intConstructor(int lottoNo, boolean badRange) {
        if (badRange) {
            assertThatExceptionOfType(LottoNoException.class)
                    .isThrownBy(() -> new LottoNo(lottoNo))
                    .withMessage(ExceptionConst.LOTTO_RANGE_MSG);
            return;
        }
        LottoNo lottoNoObj = new LottoNo(lottoNo);
        assertThat(lottoNoObj.getLottoNo())
                .isEqualTo(lottoNo);
    }

    @ParameterizedTest
    @DisplayName("1부터 45가 아닌 숫자 문자로 LottoNo을 만들면, Exception 이 발생한다.")
    @CsvSource(value = {"0$true", "1$false", "45$false", "46$true"}, delimiter = '$')
    public void strConstructor(String lottoNo, boolean badRange) {
        if (badRange) {
            assertThatExceptionOfType(LottoNoException.class)
                    .isThrownBy(() -> new LottoNo(lottoNo))
                    .withMessage(ExceptionConst.LOTTO_RANGE_MSG);
            return;
        }
        LottoNo lottoNoObj = new LottoNo(lottoNo);
        assertThat(lottoNoObj.getLottoNo())
                .isEqualTo(Integer.parseInt(lottoNo));
    }

    @Test
    @DisplayName("숫자가 아닌 값으로 LottoNo을 만들면, Exception 이 발생한다.")
    public void strConstructor() {
        Assertions.assertAll(
                () -> assertThatExceptionOfType(LottoNoException.class)
                        .isThrownBy(() -> new LottoNo(null))
                        .withMessage(ExceptionConst.NPE_MSG),
                () -> assertThatExceptionOfType(LottoNoException.class)
                        .isThrownBy(() -> new LottoNo("NAN"))
                        .withMessage(ExceptionConst.NAN_MSG)
        );
    }
}
