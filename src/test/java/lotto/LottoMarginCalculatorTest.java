package lotto;

import lotto.lotto.LottoMarginCalculator;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


class LottoMarginCalculatorTest {

    @Test
    void 마진구하기() {
        Map<LottoMarginCalculator, Integer> map = new HashMap<>();
        map.put(LottoMarginCalculator.RANK_FOUR, 1);
        map.put(LottoMarginCalculator.RANK_THREE, 1);
        map.put(LottoMarginCalculator.RANK_TWO, 0);
        map.put(LottoMarginCalculator.RANK_ONE, 0);

        assertThat(LottoMarginCalculator.calculateMarginRate(50000, map)).isEqualTo(1.1);
    }

    @Test
    void 이익이없는경우() {
        Map<LottoMarginCalculator, Integer> map = new HashMap<>();
        map.put(LottoMarginCalculator.RANK_FOUR, 0);
        map.put(LottoMarginCalculator.RANK_THREE, 0);
        map.put(LottoMarginCalculator.RANK_TWO, 0);
        map.put(LottoMarginCalculator.RANK_ONE, 0);

        assertThat(LottoMarginCalculator.calculateMarginRate(50000, map)).isEqualTo(0);
    }

    @Test
    void 한장씩된경우() {
        Map<LottoMarginCalculator, Integer> map = new HashMap<>();
        map.put(LottoMarginCalculator.RANK_FOUR, 1);
        map.put(LottoMarginCalculator.RANK_THREE, 1);
        map.put(LottoMarginCalculator.RANK_TWO, 1);
        map.put(LottoMarginCalculator.RANK_ONE, 1);

        double result = (LottoMarginCalculator.RANK_FOUR.getWinPrice() + LottoMarginCalculator.RANK_THREE.getWinPrice()
                + LottoMarginCalculator.RANK_TWO.getWinPrice() + LottoMarginCalculator.RANK_ONE.getWinPrice()) / 4000.0;

        assertThat(LottoMarginCalculator.calculateMarginRate(4000, map)).isEqualTo(result);
    }

    @Test
    void lottoMarginCalculate() {
        Map<LottoMarginCalculator, Integer> mmap = new HashMap<>();
        mmap.put(LottoMarginCalculator.RANK_FOUR, 3);
        mmap.put(LottoMarginCalculator.RANK_THREE, 1);
        mmap.put(LottoMarginCalculator.RANK_TWO, 0);
        mmap.put(LottoMarginCalculator.RANK_TWO_BONUS, 2);
        mmap.put(LottoMarginCalculator.RANK_ONE, 1);

        double result2 = ((5_000 * 3) + 50000 + (30_000_000 * 2) + 2_000_000_000) / 4000.0;

        assertThat(LottoMarginCalculator.calculateMarginRate(4000, mmap)).isEqualTo(result2);
    }

    @Test
    void 보너스_2등() {

    }

}
