package lotto;

import lotto.utility.LottoWinningStaticsCalculator;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoWinningStaticsCalculatorTest {

    @Test
    public void 당첨번호와_일치하는_번호개수() {
        assertThat(LottoWinningStaticsCalculator.countMatchingNumbers(List.of(5, 22, 31, 41, 15, 14), List.of(22, 14, 31, 6, 2, 11)))
                .isEqualTo(3);
    }

    @Test
    public void 수익률_계산() {
        Map<Integer, Integer> winningStatics = new HashMap<>();

        winningStatics.put(3, 2);

        for (int count = 4; count <= 6; count++) {
            winningStatics.put(count, 0);
        }

        assertThat(LottoWinningStaticsCalculator.calculateReturnRate(10000, winningStatics))
                .isEqualTo(1.0f);
    }

    @Test
    public void 당첨통계_계산() {
        Map<Integer, List<Integer>> lottos = new HashMap<>();

        lottos.put(1, List.of(2, 32, 24, 13, 5, 41));
        lottos.put(2, List.of(5, 21, 22, 33, 18, 14));

        Map<Integer, Integer> winningStatics = LottoWinningStaticsCalculator.calculateWinningStatics(List.of(32, 2, 13, 5, 17, 24), lottos);

        assertThat(winningStatics.get(3)).isEqualTo(0);
        assertThat(winningStatics.get(4)).isEqualTo(0);
        assertThat(winningStatics.get(5)).isEqualTo(1);
        assertThat(winningStatics.get(6)).isEqualTo(0);
    }
}
