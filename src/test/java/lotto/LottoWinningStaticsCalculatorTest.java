package lotto;

import lotto.service.LottoWinningStaticsCalculator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoWinningStaticsCalculatorTest {

    @Test
    public void 당첨통계_계산() {
        List<Integer>[] lottos = new ArrayList[2];

        lottos[0] = new ArrayList<>(List.of(2, 5, 9, 10, 23, 31));
        lottos[1] = new ArrayList<>(List.of(6, 13, 26, 41, 18, 42));


        List<Integer> winningNumbers = new ArrayList<>(List.of(2, 5, 9, 33, 35, 44));
        assertThat(LottoWinningStaticsCalculator.calculateWinningStatics(winningNumbers, lottos)).isEqualTo(new int[]{1, 0, 0, 1, 0, 0, 0});
    }

    @Test
    public void 당첨번호와_일치하는_번호개수() {
        assertThat(LottoWinningStaticsCalculator.countMatchingNumbers(List.of(5, 22, 31, 41, 15, 14), List.of(22, 14, 31, 6, 2, 11)))
                .isEqualTo(3);
    }

    @Test
    public void 총수익률_계산() {
        assertThat(LottoWinningStaticsCalculator.calculateReturnRate(10000, new int[]{0, 0, 0, 1, 0, 0, 0})).isEqualTo(0.5f);
    }

    @Test
    public void 총상금_계산() {
        assertThat(LottoWinningStaticsCalculator.calculatePrize(new int[]{0, 0, 0, 0, 2, 0, 0, 0})).isEqualTo(100_000);
    }
}
