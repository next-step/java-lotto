package lotto.domain;

import lotto.domain.Rank;
import lotto.domain.LottoRevenue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRevenueTest {
    private static HashMap<Rank, Integer> result = new HashMap<>();

    @BeforeEach
    void setUp() {
        result.put(Rank.FIRST, 1);
        result.put(Rank.SECOND, 1);
        result.put(Rank.THIRD, 1);
        result.put(Rank.FOURTH, 1);
        result.put(Rank.FIFTH, 1);
    }

    @Test
    void 총수익() {
        assertThat(LottoRevenue.revenueTotal(result)).isEqualTo(2_031_555_000);
    }

    @Test
    void 수익률() {
        int money = 10000;
        assertThat(LottoRevenue.calculateRevenue(money, LottoRevenue.revenueTotal(result))).isEqualTo(203_155.5);
    }
}
