package lottoGame.model.winner;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class WinStandardTest {

    @Test
    void 일등을_집계할_수_있다() {
        assertThat(
                WinStandard.findByValue(6, false)
        ).isEqualTo(WinStandard.FIRST);
    }

    @Test
    void 이등을_집계할_수_있다() {
        assertThat(
                WinStandard.findByValue(5, true)
        ).isEqualTo(WinStandard.SECOND_BONUS);
    }

    @Test
    void 삼등을_집계할_수_있다() {
        assertThat(
                WinStandard.findByValue(5, false)
        ).isEqualTo(WinStandard.SECOND);
    }

    @Test
    void 사등을_집계할_수_있다() {
        assertThat(
                WinStandard.findByValue(4, false)
        ).isEqualTo(WinStandard.THIRD);
    }

    @Test
    void 오등을_집계할_수_있다() {
        assertThat(
                WinStandard.findByValue(3, false)
        ).isEqualTo(WinStandard.FOURTH);
    }
}