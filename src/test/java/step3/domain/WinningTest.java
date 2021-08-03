package step3.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WinningTest {

    @Test
    void winning_1등() {
        assertThat(Winning.find(6, true)).isEqualTo(Winning.FIRST);
    }

    @Test
    void winning_2등() {
        assertThat(Winning.find(5, true)).isEqualTo(Winning.SECOND);
    }

    @Test
    void winning_3등() {
        assertThat(Winning.find(5, false)).isEqualTo(Winning.THIRD);
    }

    @Test
    void winning_4등() {
        assertThat(Winning.find(4, true)).isEqualTo(Winning.FOURTH);
    }

    @Test
    void winning_5등() {
        assertThat(Winning.find(3, true)).isEqualTo(Winning.FIFTH);
    }

    @Test
    void winning_NOTHING() {
        assertThat(Winning.find(2, true)).isEqualTo(Winning.NOTHING);
    }

}