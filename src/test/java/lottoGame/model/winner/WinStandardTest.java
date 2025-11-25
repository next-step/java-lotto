package lottoGame.model.winner;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import org.junit.jupiter.api.Test;

class WinStandardTest {

    @Test
    void 일등을_집계할_수_있다() {
        assertThat(
                WinStandard.findBy(6, false)
        ).isEqualTo(WinStandard.FIRST);
    }

    @Test
    void 이등을_집계할_수_있다() {
        assertThat(
                WinStandard.findBy(5, true)
        ).isEqualTo(WinStandard.SECOND);
    }

    @Test
    void 삼등을_집계할_수_있다() {
        assertThat(
                WinStandard.findBy(5, false)
        ).isEqualTo(WinStandard.THIRD);
    }

    @Test
    void 사등을_집계할_수_있다() {
        assertThat(
                WinStandard.findBy(4, false)
        ).isEqualTo(WinStandard.FOURTH);
    }

    @Test
    void 오등을_집계할_수_있다() {
        assertThat(
                WinStandard.findBy(3, false)
        ).isEqualTo(WinStandard.FIFTH);
    }

    @Test
    void 각등수를_키값으로하고_값이_0인_Map을_생성할_수_있다() {
        Map<WinStandard, Integer> result = WinStandard.getInitWinStandardMap();

        assertThat(result.get(WinStandard.FIRST)).isEqualTo(0);
        assertThat(result.get(WinStandard.SECOND)).isEqualTo(0);
        assertThat(result.get(WinStandard.THIRD)).isEqualTo(0);
        assertThat(result.get(WinStandard.FOURTH)).isEqualTo(0);
        assertThat(result.get(WinStandard.FIFTH)).isEqualTo(0);
    }
}