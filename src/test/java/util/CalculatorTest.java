package util;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class CalculatorTest {

    @Test
    public void yieldCalculatorTest() {
        Map<Integer, Integer> produceResults = new HashMap<>();
        produceResults.put(3, 1);
        produceResults.put(4, 0);
        produceResults.put(5, 1);
        //1505000 / 100000) * 100
        assertThat(Calculator.yieldCalculator(produceResults, 100000)).isEqualTo(15.05);
    }

    @Test
    public void nullToZeroTest() {
        assertThat(Calculator.nullToZero(null)).isEqualTo(0);
    }
}