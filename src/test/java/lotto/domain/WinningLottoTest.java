package lotto.domain;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {

    @Test
    public void 순위결정() {
        final Lotto secondLotto = new Lotto(Arrays.asList(
                LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(45)));

        final Lotto thirdLotto = new Lotto(Arrays.asList(
                LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(10)));

        final WinningLotto winningLotto
                = new WinningLotto(new Lotto(Arrays.asList(
                        LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                        LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6))), LottoNumber.of(45));

        assertThat(winningLotto.calculatePrize(secondLotto)).isEqualTo(Rank.SECOND);
        assertThat(winningLotto.calculatePrize(thirdLotto)).isEqualTo(Rank.THIRD);
    }
}