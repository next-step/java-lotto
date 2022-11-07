package lotto.domain;

import lotto.strategy.ManualNumberStrategy;
import lotto.strategy.RandomNumberStrategy;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    @Test
    void size() {
        assertThat(new Lotto(new RandomNumberStrategy()).getNumbers()).hasSize(6);
        assertThat(new Lotto(new ManualNumberStrategy("1,2,3,4,5,6")).getNumbers()).hasSize(6);
    }

    @Test
    void 범위() {
        Lotto lotto = new Lotto(new RandomNumberStrategy());
        for (Integer lottoNumber : lotto.getNumbers()) {
            assertThat(lottoNumber).isLessThanOrEqualTo(45);
        }
    }

    @Test
    void 당첨번호_개수() {
        Lotto lotto = new Lotto(() -> Arrays.asList(40,41,42,43,44,45));
        Lotto lotto2 = new Lotto(() -> Arrays.asList(1,2,3,4,5,6));
        Lotto lotto3 = new Lotto(() -> Arrays.asList(4,5,6,7,8,9));
        Lotto winningLotto = new Lotto(() -> Arrays.asList(4,5,6,7,8,9));

        assertThat(lotto.matchCnt(winningLotto)).isEqualTo(0);
        assertThat(lotto2.matchCnt(winningLotto)).isEqualTo(3);
        assertThat(lotto3.matchCnt(winningLotto)).isEqualTo(6);
    }
}
