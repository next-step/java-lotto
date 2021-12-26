package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerLottoTest {

    @Test
    void calculateRank_second() {
        // given
        WinnerLotto winnerLotto = new WinnerLotto("1, 2, 3, 4, 5, 6", 7);
        Lotto other = new Lotto("1, 2, 3, 4, 5, 7");

        // when
        Rank rank = winnerLotto.calculateRank(other);

        // then
        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @Test
    void calculateRank_third() {
        // given
        WinnerLotto winnerLotto = new WinnerLotto("1, 2, 3, 4, 5, 6", 7);
        Lotto other = new Lotto("1, 2, 3, 4, 5, 8");

        // when
        Rank rank = winnerLotto.calculateRank(other);

        // then
        assertThat(rank).isEqualTo(Rank.THIRD);
    }

}
