package lotto.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberTest {
    @Test(expected = IllegalArgumentException.class)
    public void 로또_번호가_1보다_작은_경우() {
        // given
        // when
        // then
        LottoNumber.from(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또_번호가_45보다_큰_경우() {
        // given
        // when
        // then
        LottoNumber.from(46);
    }

    @Test
    public void 유효한_로또_번호인_경우() {
        // given
        final int number = 10;

        // when
        final LottoNumber lottoNumber = LottoNumber.from(number);

        // then
        assertThat(lottoNumber.get()).isEqualTo(number);
    }
}