package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

public class WinningResultTest {
    @Test
    @DisplayName("수익률 계산 일치 확인")
    void 수익률_계산_일치_확인() {
        Map<Rank, Integer> result = new HashMap<>();
        result.put(Rank.THREE, 1);
        WinningResult winningResult = new WinningResult(result);

        double profit = winningResult.calculateProfit(new LottoMoney(14000));

        assertThat(profit).isCloseTo(0.35, within(0.01));
    }
}
