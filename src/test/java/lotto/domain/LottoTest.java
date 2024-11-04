package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

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

        Lotto lottos3 = new Lotto(1, 2, 7, 8, 9, 19);
        assertThat(lottos3.determineRank(lastWinningLotto, bonusNumber)).isEqualTo(LottoRank.ETC);
    }
}
