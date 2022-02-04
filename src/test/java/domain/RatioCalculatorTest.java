package domain;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class RatioCalculatorTest {

    @Test
    void calculateLottoRatio() {
        //given
        int purchasePrice = 100000;
        Map<Rank, Integer> matchCount = new HashMap<>();
        matchCount.put(Rank.FIFTH, 2);

        //when,then
        assertThat(RatioCalculator.calculateRatio(purchasePrice, matchCount)).isEqualTo("0.10");
    }
}