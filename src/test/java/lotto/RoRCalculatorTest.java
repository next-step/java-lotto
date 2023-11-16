package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.RoRCalculator.calculateYield;
import static org.junit.jupiter.api.Assertions.*;

class RoRCalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"0,0,0,1,1,1,0:3:51833.33", "0,0,0,1,2,1,1:5:40032100", "0,0,0,5,2,2,1:10:20031250.00", "0,0,0,2,2,2,4:10:80031100.00", "0,0,0,3,1,2,4:10:80030650.00", "0,0,0,2,3,2,0:7:45142.86"}, delimiter = ':')
    void RoRCalculator_수익률계산(String statisticsString, int lottoCount, double expected) {
        int [] statistics = Arrays.stream(statisticsString.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        assertEquals(expected, calculateYield(statistics, lottoCount));
    }
}