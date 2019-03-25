package lotto.domain;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    public void 당첨번호_일치개수_2개() {
        final Lotto winningLotto = new Lotto(Arrays.asList(
                LottoNumber.valueOf(1), LottoNumber.valueOf(2), LottoNumber.valueOf(3),
                LottoNumber.valueOf(4), LottoNumber.valueOf(5), LottoNumber.valueOf(6)));

        final Lotto lotto = new Lotto(Arrays.asList(
                LottoNumber.valueOf(11), LottoNumber.valueOf(12), LottoNumber.valueOf(10),
                LottoNumber.valueOf(16), LottoNumber.valueOf(5), LottoNumber.valueOf(6)));

        final int containsCount = winningLotto.countMatches(lotto);

        assertThat(containsCount).isEqualTo(2);
    }
}
