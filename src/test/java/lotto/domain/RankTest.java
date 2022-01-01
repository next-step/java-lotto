package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @ParameterizedTest(name = "6개 일치하고 보너스볼 일치 여부가 {0}이면 FIRST라고 판단한다.")
    @ValueSource(booleans = {true, false})
    void 로또_1등(boolean bonus) {
        // given
        Rank first = Rank.calculate(6, bonus);

        // then
        assertThat(first).isEqualTo(Rank.FIRST);
    }

    @DisplayName("5개와 보너스 볼이 일치하면 SECOND라고 판단한다.")
    @Test
    void 로또_2등() {
        // given
        Rank second = Rank.calculate(5, true);

        // then
        assertThat(second).isEqualTo(Rank.SECOND);
    }

    @DisplayName("5개가 일치하고 보너스 볼이 일치하지 않으면 THRID라고 판단한다.")
    @Test
    void 로또_3등() {
        // given
        Rank third = Rank.calculate(5, false);

        // then
        assertThat(third).isEqualTo(Rank.THIRD);
    }

    @ParameterizedTest(name = "4개 일치하고 보너스볼 일치 여부가 {0}이면 FOURTH라고 판단한다.")
    @ValueSource(booleans = {true, false})
    void 로또_4등(boolean bonus) {
        // given
        Rank fourth = Rank.calculate(4, bonus);

        // then
        assertThat(fourth).isEqualTo(Rank.FOURTH);
    }

    @ParameterizedTest(name = "3개 일치하고 보너스볼 일치 여부가 {0}이면 FIFTH라고 판단한다.")
    @ValueSource(booleans = {true, false})
    void 로또_5등(boolean bonus) {
        // given
        Rank fifth = Rank.calculate(3, bonus);

        // then
        assertThat(fifth).isEqualTo(Rank.FIFTH);
    }

    @ParameterizedTest(name = "{0}개 일치하면 NONE이라고 판단한다.")
    @ValueSource(ints = {0, 1, 2})
    void 로또_꽝(int matches) {
        // given
        Rank none = Rank.calculate(matches, true);

        // then
        assertThat(none).isEqualTo(Rank.NONE);
    }
}
