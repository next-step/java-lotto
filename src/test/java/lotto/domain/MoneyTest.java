package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class MoneyTest {

    @Test
    public void lottoBuyCountTest() {
        assertThat(new Money(4_000).buyCount()).isEqualTo(4);
    }

    @Test
    public void revenueRateTest() {
        Money money = new Money(1_000);
        Map<Rank, Integer> lottoPrizeMap = new HashMap<>();
        lottoPrizeMap.put(Rank.FIFTH, 1);

        assertThat(money.revenueRate(lottoPrizeMap)).isEqualTo(5.0);
    }

}