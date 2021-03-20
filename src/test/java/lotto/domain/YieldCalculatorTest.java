package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.LinkedHashMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class YieldCalculatorTest {
    private LinkedHashMap<Integer, Integer> resultMap = new LinkedHashMap<>();

    @BeforeEach
    void setUp() {
        resultMap.put(3, 0);
        resultMap.put(4, 0);
        resultMap.put(5, 0);
        resultMap.put(6, 0);
    }

    @ParameterizedTest
    @CsvSource(value = {"5000:3:1", "5000:4:1", "5000:5:1", "5000:6:1", "5000:3:5"}, delimiter = ':')
    void 수익률_계산(int amount, int matchNumber, int matchCount) {
        resultMap.put(matchNumber, matchCount);

        YieldCalculator yieldCalculator = new YieldCalculator(new Amount(amount));
        yieldCalculator.proceedsCalculate(resultMap);

        assertThat(yieldCalculator.proceedsTotal())
                .isEqualTo(WinningTable.of(matchNumber)
                        .multiply(matchCount));
    }
}