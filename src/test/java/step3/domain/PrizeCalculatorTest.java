package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrizeCalculatorTest {

    private static final int[] PRIZES = new int[] {0, 0, 0, 5000, 50000, 1500000, 2000000000};

    @DisplayName("총 상금 검증")
    @CsvSource(value = {"1,1", "3,4", "6,1", "4,10", "5,100"})
    @ParameterizedTest
    void totalPrizeTest(int matchCount, int winnerCount) {
        PrizeCalculator prizeCalculator = new PrizeCalculator(matchCount);

        for (int i = 0; i < winnerCount; i++) {
            prizeCalculator.addCount();
        }

        long expected = (long) PRIZES[matchCount] * winnerCount;
        long actual = prizeCalculator.getResult();
        assertEquals(expected, actual);
    }
}
