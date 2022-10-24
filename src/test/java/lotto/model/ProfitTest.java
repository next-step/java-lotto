package lotto.model;

import lotto.model.enumeration.Rank;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static lotto.model.Profit.getReturnRate;
import static org.assertj.core.api.Assertions.assertThat;

class ProfitTest {
    @Test
    public void 로또_수익금_검증() {
        Map<Rank, Long> lotteriesRank = Map.of(Rank.FIRST, 1L, Rank.THIRD, 1L);

        double result = getReturnRate(lotteriesRank, 2001500000);

        assertThat(result).isEqualTo(1.0);
    }

    @Test
    public void 로또_수익금_없는_검증() {
        Map<Rank, Long> lotteriesRank = new HashMap<>();

        double result = getReturnRate(lotteriesRank, 14000);

        assertThat(result).isEqualTo(0);
    }

}