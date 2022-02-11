package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RankTest {

    @DisplayName(value = "로또에서 3개를 맞추면 5등이다.")
    @Test
    void correctThreeFifthGrade() {
        assertThat(Rank.getRank(3)).isEqualTo(Rank.FIFTH);
    }

    @DisplayName(value = "로또에서 4개를 맞추면 4등이다.")
    @Test
    void correctFourFourthGrade() {
        assertThat(Rank.getRank(4)).isEqualTo(Rank.FOURTH);
    }

    @DisplayName(value = "로또에서 5개를 맞추면 3등이다.")
    @Test
    void correctFiveThird() {
        assertThat(Rank.getRank(5)).isEqualTo(Rank.THIRD);
    }

    @DisplayName(value = "로또에서 5개와 보너스를 맞추면 2등이다.")
    @Test
    void correctFourSecond() {
        assertThat(Rank.getRank(7)).isEqualTo(Rank.SECOND);
    }

    @DisplayName(value = "로또에서 6개를 맞추면 1등이다.")
    @Test
    void correctSixFirst() {
        assertThat(Rank.getRank(6)).isEqualTo(Rank.FIRST);
    }

    @DisplayName(value = "로또에서 3개 미만을 맞추면 꽝이다.")
    @Test
    void correctUnderThree꽝() {
        assertThat(Rank.getRank(0)).isEqualTo(Rank.NONE);
        assertThat(Rank.getRank(1)).isEqualTo(Rank.NONE1);
        assertThat(Rank.getRank(2)).isEqualTo(Rank.NONE2);

    }
}
