package lotto;

import lotto.domain.ProfitCalculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ProfitCalculatorTest {
    @Test
    void 수익_금액_계산() {
        // given
        List<Integer> equalNumberCountList = List.of(3, 4);

        // when
        int totalProfit = ProfitCalculator.calculateTotalProfit(equalNumberCountList);

        // then
        Assertions.assertThat(totalProfit).isEqualTo(55000);
    }

    @Test
    void 수익률_계산() {
        // given
        int totalPurchaseAmount = 30000;
        List<Integer> equalNumberCountList = List.of(3, 4);

        // when
        float profitRate = ProfitCalculator.calculateProfitRate(totalPurchaseAmount, equalNumberCountList);

        // then
        Assertions.assertThat(profitRate).isEqualTo(183.33f);
    }
}
