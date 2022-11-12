package step2step3.lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoNumberTest {
    @Test
    void 로또_숫자가_같으면_서로_동일한_객체다() {
        assertThat(new LottoNumber(5)).isEqualTo(new LottoNumber(5));
    }

    @ParameterizedTest
    @ValueSource(ints = {
            0,
            46
    })
    void 로또_숫자는_1이상_45이하만_가능하다(int number) {
        assertThatThrownBy(() -> new LottoNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자는 1이상 46이하이어야 합니다.");
    }

    @Test
    void 로또_숫자가_같으면_참을_반환한다() {
        LottoNumber lottoNumber = new LottoNumber(5);

        assertTrue(lottoNumber.isSameNumber(5));
    }
}
