package autoLotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RankTest {
    private GameResult result;

    @BeforeEach
    void init() {
        result = new GameResult();
    }
    @Test
    void RANK_1() {
        int winningMoney = Rank.valueOf(6, false, result);
        Assertions.assertThat(winningMoney).isEqualTo(2_000_000_000);
    }
    @Test
    void RANK_2() {
        int winningMoney = Rank.valueOf(5, true, result);
        Assertions.assertThat(winningMoney).isEqualTo(30_000_000);
    }
    @Test
    void RANK_3() {
        int winningMoney = Rank.valueOf(5, false, result);
        Assertions.assertThat(winningMoney).isEqualTo(1_500_000);
    }
    @Test
    void RANK_4() {
        int winningMoney = Rank.valueOf(4, false, result);
        Assertions.assertThat(winningMoney).isEqualTo(50_000);
    }
    @Test
    void RANK_5() {
        int winningMoney = Rank.valueOf(3, false, result);
        Assertions.assertThat(winningMoney).isEqualTo(5000);
    }
    @Test
    void RANK_MISS() {
        int winningMoney = Rank.valueOf(2, false, result);
        Assertions.assertThat(winningMoney).isEqualTo(0);
    }
}
