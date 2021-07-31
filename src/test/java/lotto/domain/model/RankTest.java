package lotto.domain.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankTest {

    @Test
    @DisplayName("일치하는 수의 개수가 1등이다.")
    void valueOf_first() {
        Rank first = Rank.valueOf(6);
        Assertions.assertThat(first).isEqualTo(Rank.FIRST);
    }

    @Test
    @DisplayName("일치하는 수의 개수가 3등이다.")
    void valueOf_third() {
        Rank third = Rank.valueOf(5);
        Assertions.assertThat(third).isEqualTo(Rank.THIRD);
    }

    @Test
    @DisplayName("일치하는 수의 개수가 4등이다.")
    void valueOf_fourth() {
        Rank first = Rank.valueOf(4);
        Assertions.assertThat(first).isEqualTo(Rank.FOURTH);
    }

    @Test
    @DisplayName("일치하는 수의 개수가 5등이다.")
    void valueOf_fifth() {
        Rank first = Rank.valueOf(3);
        Assertions.assertThat(first).isEqualTo(Rank.FIFTH);
    }

    @Test
    @DisplayName("일치하는 수의 개수가 꽝이다.")
    void valueOf_miss() {
        Rank first = Rank.valueOf(3);
        Assertions.assertThat(first).isEqualTo(Rank.FIFTH);
    }
}
