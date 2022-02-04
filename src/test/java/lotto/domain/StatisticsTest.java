package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StatisticsTest {

    @DisplayName(value = "로또에서 3개를 맞추면 5등이다.")
    @Test
    void correctThreeFifthGrade() {
        assertThat(Statistics.getRank(3)).isEqualTo(Statistics.FIFTH);
    }

    @DisplayName(value = "로또에서 4개를 맞추면 4등이다.")
    @Test
    void correctFourFourthGrade() {
        assertThat(Statistics.getRank(4)).isEqualTo(Statistics.FOURTH);
    }

    @DisplayName(value = "로또에서 5개를 맞추면 3등이다.")
    @Test
    void correctFiveThird() {
        assertThat(Statistics.getRank(5)).isEqualTo(Statistics.THIRD);
    }

    @DisplayName(value = "로또에서 4개와 보너스를 맞추면 2등이다.")
    @Test
    void correctFourSecond() {
        assertThat(Statistics.getRank(7)).isEqualTo(Statistics.SECOND);
    }

    @DisplayName(value = "로또에서 6개를 맞추면 1등이다.")
    @Test
    void correctSixFirst() {
        assertThat(Statistics.getRank(6)).isEqualTo(Statistics.FIRST);
    }
}
