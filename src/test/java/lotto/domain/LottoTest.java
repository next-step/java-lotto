package lotto.domain;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    public void 당첨번호_일치개수_2개() {
        final Lotto winningLotto = new Lotto(Arrays.asList(
                LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6)));

        final Lotto lotto = new Lotto(Arrays.asList(
                LottoNumber.of(11), LottoNumber.of(12), LottoNumber.of(10),
                LottoNumber.of(16), LottoNumber.of(5), LottoNumber.of(6)));

        final int containsCount = winningLotto.countMatches(lotto);

        assertThat(containsCount).isEqualTo(2);
    }
}
