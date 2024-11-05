package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    void create() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotto).isEqualTo(new Lotto(1, 2, 3, 4, 5, 6));
    }

    @Test
    void 등수_반환() {
        Lotto lastWinningLotto = new Lotto(1, 2, 3, 4, 5, 6);
        int bonusNumber = 45;

        Lotto lotto1 = new Lotto(1, 2, 3, 4, 5, 6);
        assertThat(lotto1.determineRank(lastWinningLotto, bonusNumber)).isEqualTo(LottoRank.FIRST);

        Lotto lotto2 = new Lotto(1, 2, 3, 4, 5, 45);
        assertThat(lotto2.determineRank(lastWinningLotto, bonusNumber)).isEqualTo(LottoRank.SECOND);

        Lotto lotto3 = new Lotto(1, 2, 3, 4, 5, 7);
        assertThat(lotto3.determineRank(lastWinningLotto, bonusNumber)).isEqualTo(LottoRank.THIRD);

        Lotto lotto4 = new Lotto(1, 2, 3, 4, 7, 8);
        assertThat(lotto4.determineRank(lastWinningLotto, bonusNumber)).isEqualTo(LottoRank.FOURTH);

        Lotto lotto5 = new Lotto(1, 2, 3, 7, 8, 9);
        assertThat(lotto5.determineRank(lastWinningLotto, bonusNumber)).isEqualTo(LottoRank.FIFTH);

        Lotto lotto6 = new Lotto(1, 2, 7, 8, 9, 10);
        assertThat(lotto6.determineRank(lastWinningLotto, bonusNumber)).isEqualTo(LottoRank.ETC);
    }
}
