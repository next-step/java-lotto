package util;

import domain.LottoRank;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class CalculatorTest {

    @Test
    public void yieldCalculatorTest() {
        Map<LottoRank, Integer> produceResults = new HashMap<>();
        produceResults.put(LottoRank.FIFTH, 1);
        produceResults.put(LottoRank.FOURTH, 0);
        produceResults.put(LottoRank.THIRD, 1);
        assertThat(Calculator.yieldCalculator(produceResults, 100000)).isEqualTo(15.05);
    }

    @Test
    public void nullToZeroTest() {
        assertThat(Calculator.nullToZero(null)).isEqualTo(0);
    }
}