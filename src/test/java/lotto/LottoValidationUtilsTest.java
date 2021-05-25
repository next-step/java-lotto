package lotto;

import lotto.exception.LottoNumberRangeException;
import lotto.exception.LottoSizeOrDuplicateException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoValidationUtilsTest {
    @DisplayName("로또 번호 유효성 체크")
    @Test
    void 중복_사이즈_테스트() {
        assertThatThrownBy(() -> LottoValidationUtils.validationLottoNumber(Arrays.asList(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(LottoSizeOrDuplicateException.class);

        assertThatThrownBy(() -> LottoValidationUtils.validationLottoNumber(Arrays.asList(1, 2, 3, 4, 5)))
                .isInstanceOf(LottoSizeOrDuplicateException.class);

        assertThatThrownBy(() -> LottoValidationUtils.validationLottoNumber(Arrays.asList(1, 2, 3, 4, 5,6,7,8)))
                .isInstanceOf(LottoSizeOrDuplicateException.class);
    }

    @DisplayName("숫자가 아닌 값")
    @Test
    void 숫자_체크() {
        assertThatThrownBy(() -> LottoValidationUtils.lottoNumberToList("1,2,r,3,4,5"))
                .isInstanceOf(NumberFormatException.class);

        assertThatThrownBy(() -> LottoValidationUtils.lottoNumberToList("1,2,4.,3,4,5"))
                .isInstanceOf(NumberFormatException.class);
    }

    @DisplayName("숫자 범위 체크")
    @Test
    void 범위_체크() {
        assertThatThrownBy(() -> LottoValidationUtils.lottoNumberToList("1,2,56,3,4,5"))
                .isInstanceOf(LottoNumberRangeException.class);
    }
}
