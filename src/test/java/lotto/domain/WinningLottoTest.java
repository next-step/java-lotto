package lotto.domain;

import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {

    @Test
    void _1등_일치_테스트() {
        WinningLotto winningLotto = new WinningLotto(asList(1, 2, 3, 4, 5, 6), 7);
        Lotto lotto = LottoFactory.createManual(asList(1, 2, 3, 4, 5, 6));

        assertThat(winningLotto.getRank(lotto))
            .isEqualTo(LottoRank.FIRST);
    }

    @Test
    void _2등_일치_테스트() {
        WinningLotto winningLotto = new WinningLotto(asList(1, 2, 3, 4, 5, 6), 7);
        Lotto lotto = LottoFactory.createManual(asList(1, 2, 3, 4, 5, 7));

        assertThat(winningLotto.getRank(lotto))
                .isEqualTo(LottoRank.SECOND);
    }

    @Test
    void _3등_일치_테스트() {
        WinningLotto winningLotto = new WinningLotto(asList(1, 2, 3, 4, 5, 6), 10);
        Lotto lotto = LottoFactory.createManual(asList(1, 2, 3, 4, 5, 7));

        assertThat(winningLotto.getRank(lotto))
            .isEqualTo(LottoRank.THIRD);
    }

    @Test
    void _4등_일치_테스트() {
        WinningLotto winningLotto = new WinningLotto(asList(1, 2, 3, 4, 5, 6), 10);
        Lotto lotto = LottoFactory.createManual(asList(1, 2, 3, 4, 8, 9));

        assertThat(winningLotto.getRank(lotto))
            .isEqualTo(LottoRank.FOURTH);
    }

    @Test
    void _5등_일치_테스트() {
        WinningLotto winningLotto = new WinningLotto(asList(1, 2, 3, 4, 5, 6), 10);
        Lotto lotto = LottoFactory.createManual(asList(1, 2, 3, 10, 11, 12));

        assertThat(winningLotto.getRank(lotto))
            .isEqualTo(LottoRank.FIFTH);
    }

    @Test
    void 당첨X_테스트() {
        WinningLotto winningLotto = new WinningLotto(asList(1, 2, 3, 4, 5, 6), 10);
        Lotto lotto = LottoFactory.createManual(asList(7, 8, 9, 10, 1, 2));

        assertThat(winningLotto.getRank(lotto))
            .isEqualTo(LottoRank.NO_RANK);
    }

}
