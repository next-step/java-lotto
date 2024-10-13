package lotto.model.dto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.model.dto.LottoNumber.*;
import static lotto.model.dto.LottoNumber.LOTTO_NUMBER_ALLOWED_BETWEEN_1_TO_45_INTEGER;

public class LottoNumberTest {
    @ParameterizedTest(name = "로또번호는_1부터_45사이")
    @ValueSource(ints = {1, 45})
    void 로또번호는_1부터_45사이이다(int validLottoNumber) {
        Assertions.assertThatNoException().isThrownBy(() -> {
            LottoNumber lottoNumber = of(validLottoNumber);
        });
    }

    @ParameterizedTest(name = "로또번호는_1부터_45사이가_아니면_오류")
    @ValueSource(ints = {0, 46})
    void 로또번호는_1부터_45사이가_아니면_오류(int illegalLottoNumber) {
        Assertions.assertThatThrownBy(() -> of(illegalLottoNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_ALLOWED_BETWEEN_1_TO_45_INTEGER);
    }

    @Test
    void 로또번호_크기비교() {
        LottoNumber lottoNumber1 = of(1);
        LottoNumber lottoNumber3 = of(3);

        int actual = lottoNumber1.compareTo(lottoNumber3);
        int expected = -1;

        Assertions.assertThat(actual).isEqualTo(expected);
    }
}
