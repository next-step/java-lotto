package lotto.domain;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    private static final LottoNumber LOTTO_1 = LottoNumber.from(1);
    private static final LottoNumber LOTTO_2 = LottoNumber.from(2);
    private static final LottoNumber LOTTO_3 = LottoNumber.from(3);
    private static final LottoNumber LOTTO_4 = LottoNumber.from(4);
    private static final LottoNumber LOTTO_5 = LottoNumber.from(5);
    private static final LottoNumber LOTTO_6 = LottoNumber.from(6);
    private static final LottoNumber LOTTO_7 = LottoNumber.from(7);
    private static final LottoNumber LOTTO_8 = LottoNumber.from(8);
    private static final LottoNumber LOTTO_9 = LottoNumber.from(9);
    private static final LottoNumber LOTTO_10 = LottoNumber.from(10);
    private static final LottoNumber LOTTO_11 = LottoNumber.from(11);
    private static final LottoNumber LOTTO_12 = LottoNumber.from(12);

    @Test
    public void 영_개_일치() {
        // given
        final LottoNumbers numbers = new LottoNumbers(Arrays.asList(LOTTO_1, LOTTO_2, LOTTO_3, LOTTO_4, LOTTO_5, LOTTO_6));
        final Lotto lotto = Lotto.manual(numbers);
        final LottoNumbers winningNumber = new LottoNumbers(Arrays.asList(LOTTO_7, LOTTO_8, LOTTO_9, LOTTO_10, LOTTO_11, LOTTO_12));

        // when
        final long howManyMatches = lotto.howManyMatches(winningNumber);

        // then
        assertThat(howManyMatches).isEqualTo(0);
    }

    @Test
    public void 세_개_일치() {
        // given
        final LottoNumbers numbers = new LottoNumbers(Arrays.asList(LOTTO_1, LOTTO_2, LOTTO_3, LOTTO_4, LOTTO_5, LOTTO_6));
        final Lotto lotto = Lotto.manual(numbers);
        final LottoNumbers winningNumber = new LottoNumbers(Arrays.asList(LOTTO_1, LOTTO_2, LOTTO_3, LOTTO_7, LOTTO_8, LOTTO_9));

        // when
        final long howManyMatches = lotto.howManyMatches(winningNumber);

        // then
        assertThat(howManyMatches).isEqualTo(3);
    }

    @Test
    public void 여섯_개_일치() {
        // given
        final LottoNumbers numbers = new LottoNumbers(Arrays.asList(LOTTO_1, LOTTO_2, LOTTO_3, LOTTO_4, LOTTO_5, LOTTO_6));
        final Lotto lotto = Lotto.manual(numbers);
        final LottoNumbers winningNumber = new LottoNumbers(Arrays.asList(LOTTO_1, LOTTO_2, LOTTO_3, LOTTO_4, LOTTO_5, LOTTO_6));

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
