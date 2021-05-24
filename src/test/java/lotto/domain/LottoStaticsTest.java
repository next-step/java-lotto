package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoStaticsTest {
    Lottos lottos;

    @BeforeEach
    public void setup() {
        lottos = new Lottos(new int[][]{
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
        });
    }

    @ParameterizedTest
    @CsvSource({"3,3","4,2","5,0","6,1"})
    public void 로또통계(int rank, int rankCount) {
        Lotto winLotto = new Lotto(1,2,3,4,5,6);
        LottoStatics statics = lottos.calculateStatics(winLotto);
        assertThat(statics.getRankCount(rank)).isEqualTo(rankCount);
    }

    @Test
    public void 수익률() {
        Lotto winLotto = new Lotto(1,2,3,4,5,6);
        LottoStatics statics = lottos.calculateStatics(winLotto);
        assertThat(statics.getProfit()).isEqualTo(200011.5);
    }

    @ParameterizedTest
    @MethodSource("provideLottoGames")
    public void 수익률2(Lottos lottos) {
        Lotto winLotto = new Lotto(1,2,3,4,5,6);
        LottoStatics statics = lottos.calculateStatics(winLotto);
        assertThat(statics.getProfit()).isEqualTo(0.35);
    }

    private static Stream<Arguments> provideLottoGames() {
        return Stream.of(
                Arguments.of(new Lottos(new int[][] {
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
                })));
    }

}
