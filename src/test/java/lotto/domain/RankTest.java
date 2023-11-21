package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankTest {
    @Test
    @DisplayName("1등")
    void rank_1() {
        Rank rank = Rank.rank(6);
        Assertions.assertThat(rank).isEqualTo(Rank.FIRST);
    }
    @Test
    @DisplayName("2등")
    void rank_2() {
        Rank rank = Rank.rank(5);
        Assertions.assertThat(rank).isEqualTo(Rank.SECOND);
    }
    @Test
    @DisplayName("3등")
    void rank_3() {
        Rank rank = Rank.rank(4);
        Assertions.assertThat(rank).isEqualTo(Rank.THIRD);
    }
    @Test
    @DisplayName("4등")
    void rank_4() {
        Rank rank = Rank.rank(3);
        Assertions.assertThat(rank).isEqualTo(Rank.FOURTH);
    }
    @Test
    @DisplayName("5등")
    void rank_5() {
        Rank rank = Rank.rank(2);
        Assertions.assertThat(rank).isEqualTo(Rank.FIFTH);
    }
    @Test
    @DisplayName("꽝")
    void rank_0() {
        Rank rank = Rank.rank(1);
        Assertions.assertThat(rank).isEqualTo(Rank.NO_MATCH);
    }
}
