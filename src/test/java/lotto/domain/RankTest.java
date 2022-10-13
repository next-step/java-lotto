package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RankTest {

    @Test
    @DisplayName("5개 일치하고 보너스 볼을 못맞추면 3등이다.")
    void 로또3등() {
        Rank third = Rank.calculate(5, false);

        assertThat(third).isEqualTo(Rank.THIRD);
    }

    @Test
    @DisplayName("5개 일치하고 보너스 볼을 맞추면 2등이다.")
    void 로또2등() {
        Rank second = Rank.calculate(5, true);

        assertThat(second).isEqualTo(Rank.SECOND);
    }

    @ParameterizedTest(name = "{0} 개 일치하면 꽝이다.")
    @ValueSource(ints = {0, 1, 2})
    void 꽝(int value) {
        Rank none = Rank.calculate(value, true);

        assertThat(none).isEqualTo(Rank.NONE);
    }
}