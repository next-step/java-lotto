package lotto.domain;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {

    @Test
    public void 순위결정() {
        final Lotto secondLotto = new Lotto(Arrays.asList(
                LottoNumber.valueOf(1), LottoNumber.valueOf(2), LottoNumber.valueOf(3),
                LottoNumber.valueOf(4), LottoNumber.valueOf(5), LottoNumber.valueOf(45)));

        final Lotto thirdLotto = new Lotto(Arrays.asList(
                LottoNumber.valueOf(1), LottoNumber.valueOf(2), LottoNumber.valueOf(3),
                LottoNumber.valueOf(4), LottoNumber.valueOf(5), LottoNumber.valueOf(10)));

        final WinningLotto winningLotto
                = new WinningLotto(new Lotto(Arrays.asList(
                        LottoNumber.valueOf(1), LottoNumber.valueOf(2), LottoNumber.valueOf(3),
                        LottoNumber.valueOf(4), LottoNumber.valueOf(5), LottoNumber.valueOf(6))), LottoNumber.valueOf(45));

        assertThat(winningLotto.determineRank(secondLotto)).isEqualTo(Rank.SECOND);
        assertThat(winningLotto.determineRank(thirdLotto)).isEqualTo(Rank.THIRD);
    }
}