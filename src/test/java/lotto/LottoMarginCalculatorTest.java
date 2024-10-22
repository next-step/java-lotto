package lotto;

import lotto.lotto.LottoMargin;
import lotto.lotto.LottoMarginCalculator;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


class LottoMarginCalculatorTest {

    @Test
    void 마진구하기() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(3, 1);
        map.put(4, 1);
        map.put(5, 0);
        map.put(6, 0);

        LottoMargin margin = new LottoMargin(50000, map);

        assertThat(margin.getMarginRate()).isEqualTo(1.1);
    }

    @Test
    void 이익이없는경우() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(3, 0);
        map.put(4, 0);
        map.put(5, 0);
        map.put(6, 0);

        LottoMargin margin = new LottoMargin(50000, map);

        assertThat(margin.getMarginRate()).isEqualTo(0);
    }

    @Test
    void 한장씩된경우() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(3, 1);
        map.put(4, 1);
        map.put(5, 1);
        map.put(6, 1);
        double result = (5000 + 50000 + 1500000 + 200000000) / 4000.0;

        LottoMargin margin = new LottoMargin(4000, map);

        assertThat(margin.getMarginRate()).isEqualTo(result);
    }

    @Test
    void lottoMarginCalculate() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(3, 1);
        map.put(4, 1);
        map.put(5, 1);
        map.put(6, 1);
        double result = (5000 + 50000 + 1500000 + 200000000) / 4000.0;

        assertThat(LottoMarginCalculator.calculateMarginRate(4000, map)).isEqualTo(result);
    }
}
