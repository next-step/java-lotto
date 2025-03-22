package lotto.domain;

import java.util.Arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoRankTest {

    @Test
    void MATCH6_일치_테스트() {
        WinningLotto winningLotto = new WinningLotto(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);

        assertThat(LottoRank.getRank(winningLotto, lotto))
            .isEqualTo(LottoRank.MATCH_6);
    }

    @Test
    void MATCH5_일치_테스트() {
        WinningLotto winningLotto = new WinningLotto(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 7);

        assertThat(LottoRank.getRank(winningLotto, lotto))
            .isEqualTo(LottoRank.MATCH_5);
    }

    @Test
    void MATCH4_일치_테스트() {
        WinningLotto winningLotto = new WinningLotto(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(1, 2, 3, 4, 8, 9);

        assertThat(LottoRank.getRank(winningLotto, lotto))
            .isEqualTo(LottoRank.MATCH_4);
    }

    @Test
    void MATCH3_일치_테스트() {
        WinningLotto winningLotto = new WinningLotto(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(1, 2, 3, 10, 11, 12);

        assertThat(LottoRank.getRank(winningLotto, lotto))
            .isEqualTo(LottoRank.MATCH_3);
    }

    @Test
    void NO_MATCH_테스트() {
        WinningLotto winningLotto = new WinningLotto(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(7, 8, 9, 10, 1, 2);

        assertThat(LottoRank.getRank(winningLotto, lotto))
            .isEqualTo(LottoRank.NO_MATCH);
    }

}
