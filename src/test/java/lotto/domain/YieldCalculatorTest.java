package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class YieldCalculatorTest {
    @Test
    @DisplayName("3000원으로 3등하나 당첨시 수익률 1.66")
    void yield_test() {
        int purchaseAmount = 3000;
        Map<WinType, Integer> winResultMap = new EnumMap<>(WinType.class);
        winResultMap.put(WinType.THREE_MATCH, 1);
        String yield = YieldCalculator.calculateYield(purchaseAmount, winResultMap);

        assertThat(yield).isEqualTo("1.66");
    }

    @Test
    @DisplayName("3000원으로 0개 당첨시 수익률 0")
    void yield_zero_test() {
        int purchaseAmount = 3000;
        Map<WinType, Integer> winResultMap = new EnumMap<>(WinType.class);
        String yield = YieldCalculator.calculateYield(purchaseAmount, winResultMap);

        assertThat(yield).isEqualTo("0");
    }
}
