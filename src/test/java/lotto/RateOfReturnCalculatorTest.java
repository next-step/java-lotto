package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RateOfReturnCalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"0,0,0,1,1,1,0:14000:11107", "0,0,0,1,2,0,0:14500:724", "0,0,0,5,0,0,0:10000:250", "0,0,0,2,0,2,0:15000:20067", "0,0,0,3,1,2,4:15000:53353767", "0,0,0,2,3,2,0:10000:31600", "0,0,0,1,0,0,0:14000:36"}, delimiter = ':')
    void RoRCalculator_수익률계산(String statisticsString, int money, double expected) {
        RateOfReturnCalculator rateOfReturnCalculator = new RateOfReturnCalculator();

        int [] statistics = Arrays.stream(statisticsString.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        double actual = rateOfReturnCalculator.calculateYield(statistics, money);
        assertEquals(Math.round(expected), Math.round(actual * 100));
    }
}