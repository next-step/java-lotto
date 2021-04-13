package lotto.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @Test
    @DisplayName("3등이 잘 나오는지 확인")
    void valueFirstTest() {
        Rank rank = Rank.valueOf(6, false);
        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @Test
    @DisplayName("2등이 잘 나오는지 확인")
    void valueSecondTest() {
        Rank rank = Rank.valueOf(5, true);
        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @Test
    @DisplayName("3등이 잘 나오는지 확인")
    void valueThirdTest() {
        Rank rank = Rank.valueOf(5, false);
        assertThat(rank).isEqualTo(Rank.THIRD);
    }

    @Test
    @DisplayName("4등이 잘 나오는지 확인")
    void valueFourthTest() {
        Rank rank = Rank.valueOf(4, false);
        assertThat(rank).isEqualTo(Rank.FOURTH);
    }
    @Test
    @DisplayName("5등이 잘 나오는지 확인")
    void valueFifthTest() {
        Rank rank = Rank.valueOf(3, false);
        assertThat(rank).isEqualTo(Rank.FIFTH);
    }

    @Test
    @DisplayName("꽝이 잘 나오는지 확인")
    void valueBombTest() {
        Rank rank = Rank.valueOf(2, false);
        assertThat(rank).isEqualTo(Rank.MISS);
    }

    @Test
    @DisplayName("꽝이 잘 나오는지 확인2")
    void valueBombTest2() {
        Rank rank = Rank.valueOf(0, false);
        assertThat(rank).isEqualTo(Rank.MISS);
    }




}
