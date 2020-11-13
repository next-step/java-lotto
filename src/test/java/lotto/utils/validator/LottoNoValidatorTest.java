package lotto.utils.validator;

import lotto.asset.ExceptionConst;
import lotto.exception.LottoRangeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoNoValidatorTest {

    @ParameterizedTest
    @DisplayName("1부터 45사이의 숫자만 true 이다.")
    @CsvSource(value = {"0$false", "1$true", "45$true", "46$false"}, delimiter = '$')
    void checkLottoRange(int input, boolean expected) {
        assertThat(LottoNoValidator.checkLottoRange(input))
                .isEqualTo(expected);
    }


    @ParameterizedTest
    @DisplayName("1부터 45가 아면, Exception 이 발생한다.")
    @CsvSource(value = {"0$true", "1$false", "45$false", "46$true"}, delimiter = '$')
    public void intValidateLottoNo(int lottoNo, boolean badRange) {
        if (badRange) {
            assertThatExceptionOfType(LottoRangeException.class)
                    .isThrownBy(() -> LottoNoValidator.validateLottoNo(lottoNo))
                    .withMessage(ExceptionConst.LOTTO_RANGE_MSG);
            return;
        }
        Assertions.assertDoesNotThrow(() -> LottoNoValidator.validateLottoNo(lottoNo));
    }
}
