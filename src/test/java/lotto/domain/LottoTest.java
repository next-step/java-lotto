package lotto.domain;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    public void 당첨번호_일치개수_2개() {
        final Lotto winningLotto = new Lotto(Arrays.asList(
                LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3),
                LottoNumber.from(4), LottoNumber.from(5), LottoNumber.from(6)));

        final Lotto lotto = new Lotto(Arrays.asList(
                LottoNumber.from(11), LottoNumber.from(12), LottoNumber.from(10),
                LottoNumber.from(16), LottoNumber.from(5), LottoNumber.from(6)));

        final int containsCount = winningLotto.countMatches(lotto);

        assertThat(containsCount).isEqualTo(2);
    }
}
