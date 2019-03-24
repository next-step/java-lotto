package lotto.domain;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {

    @Test
    public void 순위결정() {
        final Lotto secondLotto = new Lotto(Arrays.asList(
                LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3),
                LottoNumber.from(4), LottoNumber.from(5), LottoNumber.from(45)));

        final Lotto thirdLotto = new Lotto(Arrays.asList(
                LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3),
                LottoNumber.from(4), LottoNumber.from(5), LottoNumber.from(10)));

        final WinningLotto winningLotto
                = new WinningLotto(new Lotto(Arrays.asList(
                        LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3),
                        LottoNumber.from(4), LottoNumber.from(5), LottoNumber.from(6))), LottoNumber.from(45));

        assertThat(winningLotto.determineRank(secondLotto)).isEqualTo(Rank.SECOND);
        assertThat(winningLotto.determineRank(thirdLotto)).isEqualTo(Rank.THIRD);
    }
}