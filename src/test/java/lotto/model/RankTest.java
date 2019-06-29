package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {
    @Test
    @DisplayName("1등은 숫자 6개가 일치한다.")
    void determine_1st() {
        assertThat(Rank.valueOf(6, false)).isEqualByComparingTo(Rank.FIRST);
        assertThat(Rank.valueOf(6, true)).isEqualByComparingTo(Rank.FIRST);
    }

    @Test
    @DisplayName("2등은 숫자 5개가 일치하고 보너스 숫자 하나를 포함한다.")
    void determine_2nd() {
        assertThat(Rank.valueOf(5, true)).isEqualByComparingTo(Rank.SECOND);
    }

    @Test
    @DisplayName("3등은 숫자 5개가 일치하고 보너스 숫자를 포함하지 않는다.")
    void determine_3rd() {
        assertThat(Rank.valueOf(5, false)).isEqualByComparingTo(Rank.THIRD);
    }

    @Test
    @DisplayName("4등은 숫자 4개가 일치한다.")
    void determine_4th() {
        assertThat(Rank.valueOf(4, false)).isEqualByComparingTo(Rank.FOURTH);
        assertThat(Rank.valueOf(4, true)).isEqualByComparingTo(Rank.FOURTH);
    }

    @Test
    @DisplayName("5등은 숫자 3개가 일치한다.")
    void determine_5th() {
        assertThat(Rank.valueOf(3, false)).isEqualByComparingTo(Rank.FIFTH);
        assertThat(Rank.valueOf(4, true)).isEqualByComparingTo(Rank.FOURTH);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    @DisplayName("일치하는 갯수가 3개 미만이면 꽝이다")
    void determine_Miss(int countOfMatch) {
        assertThat(Rank.valueOf(countOfMatch, false)).isEqualByComparingTo(Rank.MISS);
        assertThat(Rank.valueOf(countOfMatch, true)).isEqualByComparingTo(Rank.MISS);
    }
}
