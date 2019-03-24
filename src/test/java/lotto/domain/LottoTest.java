package lotto.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    public void 영_개_일치() {
        // given
        final LottoNumbers numbers = new LottoNumbers("1, 2, 3, 4, 5, 6");
        final Lotto lotto = Lotto.manual(numbers);
        final LottoNumbers winningNumber = new LottoNumbers("7, 8, 9, 10, 11, 12");

        // when
        final long howManyMatches = lotto.howManyMatches(winningNumber);

        // then
        assertThat(howManyMatches).isEqualTo(0);
    }

    @Test
    public void 세_개_일치() {
        // given
        final LottoNumbers numbers = new LottoNumbers("1, 2, 3, 4, 5, 6");
        final Lotto lotto = Lotto.manual(numbers);
        final LottoNumbers winningNumber = new LottoNumbers("1, 2, 3, 7, 8, 9");

        // when
        final long howManyMatches = lotto.howManyMatches(winningNumber);

        // then
        assertThat(howManyMatches).isEqualTo(3);
    }

    @Test
    public void 여섯_개_일치() {
        // given
        final LottoNumbers numbers = new LottoNumbers("1, 2, 3, 4, 5, 6");
        final Lotto lotto = Lotto.manual(numbers);
        final LottoNumbers winningNumber = numbers;

        // when
        final long howManyMatches = lotto.howManyMatches(winningNumber);

        // then
        assertThat(howManyMatches).isEqualTo(6);
    }

    @Test
    public void 자동_생성() {
        // given
        // when
        // then
        Lotto.automatic();
    }
}
