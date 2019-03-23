package lotto.domain;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    public void 당첨번호_일치개수_2개() {
        final Lotto winningLotto = new Lotto(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));

        final Lotto lotto = new Lotto(Arrays.asList(
                new LottoNumber(11), new LottoNumber(12), new LottoNumber(10),
                new LottoNumber(16), new LottoNumber(5), new LottoNumber(6)));

        final int containsCount = winningLotto.countMatches(lotto);

        assertThat(containsCount).isEqualTo(2);
    }
}
