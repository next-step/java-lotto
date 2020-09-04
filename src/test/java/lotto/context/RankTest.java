package lotto.context;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RankTest {

    @Test
    void getCountOfMatch() {
        Assertions.assertThat(Rank.FOURTH.getCountOfMatch()).isEqualTo(3);
        Assertions.assertThat(Rank.THIRD.getCountOfMatch()).isEqualTo(4);
    }

    @Test
    void getWinningMoney() {
        Assertions.assertThat(Rank.FOURTH.getWinningMoney()).isEqualTo(5000);
        Assertions.assertThat(Rank.THIRD.getWinningMoney()).isEqualTo(50000);
    }

    @Test
    void getRank() {
        Assertions.assertThat(Rank.getRank(4, false)).isEqualTo(Rank.FOURTH);
    }

    @Test
    void getMatchRankCount() {
        Assertions.assertThat(Rank.getMatchRankCount(5)).isEqualTo(2);
    }

    @Test
    void isBonus() {
        Assertions.assertThat(Rank.isBonus(2, true)).isTrue();
        Assertions.assertThat(Rank.isBonus(2, false)).isTrue();
    }
}