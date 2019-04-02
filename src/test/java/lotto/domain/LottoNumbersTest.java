package lotto.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersTest {
    @Test(expected = IllegalArgumentException.class)
    public void 로또_번호가_여섯_개_초과한_경우() {
        // given
        // when
        // then
        new LottoNumbers(1, 2, 3, 4, 5, 6, 7);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또_번호가_중복인_경우() {
        // given
        // when
        // then
        new LottoNumbers(1, 1, 1, 1, 1, 1);
    }

    @Test
    public void 가지고_있는_로또_번호인_경우() {
        // given
        final int lottoNumber = 1;
        final LottoNumbers lottoNumbers = new LottoNumbers(lottoNumber, 2, 3, 4, 5, 6);

        // when
        final boolean contains = lottoNumbers.contains(LottoNumber.from(lottoNumber));

        // then
        assertThat(contains).isTrue();
    }

    @Test
    public void 여섯_개_일치() {
        // given
        final LottoNumbers lottoNumbers = new LottoNumbers(1, 2, 3, 4, 5, 6);

        // when
        final long howManyMatches = lottoNumbers.howManyMatches(lottoNumbers);

        // then
        assertThat(howManyMatches).isEqualTo(6);
    }
}
