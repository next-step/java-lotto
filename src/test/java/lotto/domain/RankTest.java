package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @DisplayName("6개가 모두 일치하면 FIRST라고 판단한다.")
    @Test
    void first() {
        // given
        Rank first = Rank.calculate(6);

        // then
        assertThat(first).isEqualTo(Rank.FIRST);
    }

    @DisplayName("5개가 일치하면 SECOND라고 판단한다.")
    @Test
    void second() {
        // given
        Rank second = Rank.calculate(5);

        // then
        assertThat(second).isEqualTo(Rank.SECOND);
    }

    @DisplayName("4개가 일치하면 THRID라고 판단한다.")
    @Test
    void third() {
        // given
        Rank third = Rank.calculate(4);

        // then
        assertThat(third).isEqualTo(Rank.THIRD);
    }

    @DisplayName("3개가 일치하면 FOURTH라고 판단한다.")
    @Test
    void fourth() {
        // given
        Rank fourth = Rank.calculate(3);

        // then
        assertThat(fourth).isEqualTo(Rank.FOURTH);
    }

    @DisplayName("2개 이하로 일치하면 NONE이라고 판단한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    void none(int matches) {
        // given
        Rank none = Rank.calculate(matches);

        // then
        assertThat(none).isEqualTo(Rank.NONE);
    }
}
