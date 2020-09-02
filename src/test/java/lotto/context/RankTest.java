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
        Assertions.assertThat(Rank.getRank(3)).isEqualTo(Rank.FOURTH);
    }
}