package lotto.model.dto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.model.dto.LottoNumber.LOTTO_NUMBER_ALLOWED_BETWEEN_1_TO_45_INTEGER;

public class LottoNumberTest {
    @Test
    void 로또번호를_저장한다() {
        Assertions.assertThatNoException().isThrownBy(() -> {
            LottoNumber lottoNumber1 = new LottoNumber(1);
            LottoNumber lottoNumber45 = new LottoNumber(45);
        });
    }

    @ParameterizedTest(name = "로또번호는_1부터_45사이가_아니면_오류")
    @ValueSource(ints = {0, 46})
    void 로또번호는_1부터_45사이가_아니면_오류(int illegalLottoNumber) {
        Assertions.assertThatThrownBy(() -> new LottoNumber(illegalLottoNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_ALLOWED_BETWEEN_1_TO_45_INTEGER);
    }

    @Test
    void 로또번호_크기비교() {
        LottoNumber lottoNumber1 = new LottoNumber(1);
        LottoNumber lottoNumber3 = new LottoNumber(3);

        int actual = lottoNumber1.compareTo(lottoNumber3);
        int expected = -1;

        Assertions.assertThat(actual).isEqualTo(expected);
    }
}
