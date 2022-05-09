package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {
    @Test
    @DisplayName("1등")
    void first() {
        assertThat(Rank.of(6,false) == Rank.FIRST).isTrue();
    }

    @Test
    @DisplayName("2등")
    void second() {
        assertThat(Rank.of(5,true) == Rank.SECOND).isTrue();
    }

    @Test
    @DisplayName("3등")
    void third() {
        assertThat(Rank.of(5,false) == Rank.THIRD).isTrue();
    }
}
