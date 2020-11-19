package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class WinningConditionTest {

    @Test
    @DisplayName("5등 getRank 테스트")
    void getRank_fifth() {

        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9));
        LottoNo bonus = LottoNoPool.getLottoNo(3);
        WinningCondition condition = new WinningCondition(winningLotto, bonus);
        assertThat(condition.getRank(lotto))
                .isEqualTo(Rank.FIFTH);
    }

    @Test
    @DisplayName("3등 getRank 테스트")
    void getRank_third() {

        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(Arrays.asList(2, 3, 4, 5, 6, 7));
        LottoNo bonus = LottoNoPool.getLottoNo(8);
        WinningCondition condition = new WinningCondition(winningLotto, bonus);
        assertThat(condition.getRank(lotto))
                .isEqualTo(Rank.THIRD);
    }

    @Test
    @DisplayName("2등 getRank 테스트")
    void getRank_second() {

        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(Arrays.asList(2, 3, 4, 5, 6, 7));
        LottoNo bonus = LottoNoPool.getLottoNo(1);
        WinningCondition condition = new WinningCondition(winningLotto, bonus);
        assertThat(condition.getRank(lotto))
                .isEqualTo(Rank.SECOND);
    }
}
