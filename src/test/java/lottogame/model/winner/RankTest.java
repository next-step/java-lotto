package lottogame.model.winner;

import static lottogame.model.winner.Rank.*;
import static lottogame.model.winner.Rank.FIRST;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import org.junit.jupiter.api.Test;

class RankTest {

    @Test
    void 일등을_집계할_수_있다() {
        assertThat(
                findBy(6, false)
        ).isEqualTo(FIRST);
    }

    @Test
    void 이등을_집계할_수_있다() {
        assertThat(
                findBy(5, true)
        ).isEqualTo(SECOND);
    }

    @Test
    void 삼등을_집계할_수_있다() {
        assertThat(
                findBy(5, false)
        ).isEqualTo(THIRD);
    }

    @Test
    void 사등을_집계할_수_있다() {
        assertThat(
                findBy(4, false)
        ).isEqualTo(FOURTH);
    }

    @Test
    void 오등을_집계할_수_있다() {
        assertThat(
                findBy(3, false)
        ).isEqualTo(FIFTH);
    }

    @Test
    void 각등수를_키값으로하고_값이_0인_Map을_생성할_수_있다() {
        Map<Rank, Integer> result = getInitWinStandardMap();

        assertThat(result.get(FIRST)).isEqualTo(0);
        assertThat(result.get(SECOND)).isEqualTo(0);
        assertThat(result.get(THIRD)).isEqualTo(0);
        assertThat(result.get(FOURTH)).isEqualTo(0);
        assertThat(result.get(FIFTH)).isEqualTo(0);
    }

    @Test
    void 등수의_당첨갯수를_통해_총_당첨금액을_계산할_수_있다() {
        assertThat(FIRST.calculateWinReturn(2)).isEqualTo(2_000_000_000 * 2);
        assertThat(SECOND.calculateWinReturn(2)).isEqualTo(30_000_000 * 2);
        assertThat(THIRD.calculateWinReturn(2)).isEqualTo(1_500_000 * 2);
        assertThat(FOURTH.calculateWinReturn(2)).isEqualTo(50_000 * 2);
        assertThat(FIFTH.calculateWinReturn(2)).isEqualTo(5_000 * 2);
    }
}