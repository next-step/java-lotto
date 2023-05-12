package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class RankResultTest {

    @Test
    void calculateWinningAmount() {
        RankResult rankResult = getRankResult();

        Money winningAmount = rankResult.calculateWinningAmount();

        assertThat(winningAmount).isEqualTo(new Money(2_031_555_000L));
    }

    @Test
    void calculateRateOfEarning() {
        RankResult rankResult = getRankResult();

        double rateOfEarning = rankResult.calculateRateOfEarning(new Money(2_031_555_000L));
        assertThat(rateOfEarning).isEqualTo(1);
    }

    public static RankResult getRankResult() {
        Map<Rank, Long> map = new LinkedHashMap<>();
        map.put(Rank.FIFTH, 1L);
        map.put(Rank.FOURTH, 1L);
        map.put(Rank.THIRD, 1L);
        map.put(Rank.SECOND, 1L);
        map.put(Rank.FIRST, 1L);

        return new RankResult(map);
    }
}