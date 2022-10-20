package lotto.model;

import lotto.model.enumeration.Rank;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class ProfitTest {
    @Test
    public void 로또_당첨금_검증() {
        Profit profit = new Profit(Map.of(Rank.FIRST, 2L, Rank.THIRD, 1L));

        long result = profit.getTotalWinningMoney();

        assertThat(result).isEqualTo(4001500000L);
    }

    @Test
    public void 로또_당첨금_없는_검증() {
        Profit profit = new Profit(new HashMap<>());

        long result = profit.getTotalWinningMoney();

        assertThat(result).isEqualTo(0);
    }

}