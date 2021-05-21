package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoStaticsTest {
    LottoMachine machine;

    @BeforeEach
    public void setup() {
        machine = new LottoMachine(new LottoGames(new int[][]{
                {1, 2, 3, 4, 5, 6},     // 6
                {1, 2, 3, 41, 42, 43},  // 3
                {41, 42, 43, 1, 2, 3},  // 3
                {41, 42, 43, 4, 5, 6},  // 3
                {1,2,3,4,12,13},//4
                {12,13,3,4,5,6},//4
                {11,12,13,14,15,16}, // 0
                {1,11,12,13,14,15}, // 1
                {11,12,13,14,15,6}, // 1
                {11,2,3,14,15,16} // 2
        }));
    }

    @Test
    public void 로또통계() {
        LottoGame winLottoGame = new LottoGame(1,2,3,4,5,6);
        LottoStatics statics = machine.calculateStatics(winLottoGame);
        assertThat(statics.getRankCount(3)).isEqualTo(3);
        assertThat(statics.getRankCount(4)).isEqualTo(2);
        assertThat(statics.getRankCount(5)).isEqualTo(0);
        assertThat(statics.getRankCount(6)).isEqualTo(1);
    }

    @Test
    public void 수익률() {
        LottoGame winLottoGame = new LottoGame(1,2,3,4,5,6);
        LottoStatics statics = machine.calculateStatics(winLottoGame);
        assertThat(statics.getProfit().calculateRate()).isEqualTo(200011.5);
    }

    @Test
    public void 수익률2() {
        LottoMachine machine = new LottoMachine(new LottoGames(new int[][] {
                {8, 21, 23, 41, 42, 43},
                {3, 5, 11, 16, 32, 38},
                {7, 11, 16, 35, 36, 44},
                {1, 8, 11, 31, 41, 42},
                {13, 14, 16, 38, 42, 45},
                {7, 11, 30, 40, 42, 43},
                {2, 13, 22, 32, 38, 45},
                {23, 25, 33, 36, 39, 41},
                {1, 3, 5, 14, 22, 45},
                {5, 9, 38, 41, 43, 44},
                {2, 8, 9, 18, 19, 21},
                {13, 14, 18, 21, 23, 35},
                {17, 21, 29, 37, 42, 45},
                {3, 8, 27, 30, 35, 44},
        }));
        LottoGame winLottoGame = new LottoGame(1,2,3,4,5,6);
        LottoStatics statics = machine.calculateStatics(winLottoGame);
        assertThat(statics.getProfit().calculateRate()).isEqualTo(0.35);
    }

}
