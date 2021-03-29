package im.juniq.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class WinningTest {

    @Test
    void findByMatchedCount() {
        assertThat(Winning.findByMatchedCount(6)).isEqualTo(Winning.SIX_NUMBERS_MATCHED);
        assertThat(Winning.findByMatchedCount(5)).isEqualTo(Winning.FIVE_NUMBERS_MATCHED);
        assertThat(Winning.findByMatchedCount(4)).isEqualTo(Winning.FOUR_NUMBERS_MATCHED);
        assertThat(Winning.findByMatchedCount(3)).isEqualTo(Winning.THREE_NUMBERS_MATCHED);
        assertThat(Winning.findByMatchedCount(2)).isEqualTo(Winning.LOSING);
        assertThat(Winning.findByMatchedCount(1)).isEqualTo(Winning.LOSING);
        assertThat(Winning.findByMatchedCount(0)).isEqualTo(Winning.LOSING);
    }
}