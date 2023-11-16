package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static lotto.RoRCalculator.calculateYield;
import static org.junit.jupiter.api.Assertions.*;

class RoRCalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"0,0,0,1,1,1,0:3:518", "0,0,0,1,2,1,1:5:400321", "0,0,0,5,2,2,1:10:200313", "0,0,0,2,2,2,4:10:800311", "0,0,0,3,1,2,4:10:800307", "0,0,0,2,3,2,0:7:451"}, delimiter = ':')
    void RoRCalculator_수익률계산(String statisticsString, int lottoCount, double expected) {
        int [] statistics = Arrays.stream(statisticsString.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        assertEquals(Math.round(expected), Math.round(calculateYield(statistics, lottoCount)));
    }
}