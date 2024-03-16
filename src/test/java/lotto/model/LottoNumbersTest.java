package lotto.model;

import lotto.exception.InvalidLottoException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumbersTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void 로또번호가_1에서_45사이_값이_아니면_예외를_던진다(int given) {
        assertThatThrownBy(() -> LottoNumbers.of(given))
                .isInstanceOf(InvalidLottoException.class);
    }

    @Test
    void 중복제외한_로또번호를_반환한다() {
        int expected = 2;

        List<LottoNumber> lottoNumbers = LottoNumbers.of(1, 1, 1, 1, 1, 2);

        assertThat(lottoNumbers)
                .hasSize(expected)
                .containsExactly(new LottoNumber(1), new LottoNumber(2));
    }
}
