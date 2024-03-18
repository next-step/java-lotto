package model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

class LottosTest {

    @Test
    void 당첨_등수_결과를_확인한다() {
        // given
        final Lottos lottos = new Lottos(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 8, 9))));
        final WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        final LottoNumber lottoNumber = new LottoNumber(7);
        final LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(winningNumbers, lottoNumber);

        // when
        final List<Rank> ranks = lottos.determineRank(lottoWinningNumber);

        // then
        assertThat(ranks).containsExactly(Rank.FIRST, Rank.SECOND, Rank.FOURTH);
    }
}
