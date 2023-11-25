package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.PrizeSummary;
import lotto.domain.Profit;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningCombo;
import org.junit.jupiter.api.Test;

public class ProfitTest {

    @Test
    void calculateProfit() {
        // given
        Lottos lottos = new Lottos(List.of(Lotto.from(List.of(1, 2, 30, 31, 32, 33)),
                Lotto.from(List.of(1, 2, 3, 41, 42, 43)),
                Lotto.from(List.of(1, 2, 4, 40, 42, 43)),
                Lotto.from(List.of(1, 2, 3, 4, 41, 42))));
        WinningCombo winningCombo = WinningCombo.of(List.of(1, 2, 3, 4, 5, 6), 45);

        PrizeSummary prizeSummary = lottos.getPrizeSummary(winningCombo);

        // when
        Profit profit = Profit.of(new PurchaseAmount(13000), prizeSummary);

        // then
        assertThat(Math.round(profit.getProfit() * 100) / 100.0).isEqualTo(4.62);
    }
}
