package lotto.model.enumeration;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static lotto.model.enumeration.Rank.getTotalWinningMoney;
import static org.assertj.core.api.Assertions.assertThat;

class RankTest {
    @Test
    public void 로또_당첨금_검증() {
        Map<Rank, Long> lotteriesRank = Map.of(Rank.FIRST, 2L, Rank.THIRD, 1L);

        long result = getTotalWinningMoney(lotteriesRank);

        assertThat(result).isEqualTo(4001500000L);
    }

    @Test
    public void 로또_당첨금_없는_검증() {
        long result = getTotalWinningMoney(new HashMap<>());

        assertThat(result).isEqualTo(0);
    }

}