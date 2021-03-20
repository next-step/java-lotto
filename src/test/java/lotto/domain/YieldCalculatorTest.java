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
        resultMap.put(WinningTable.THREE.matchNumber, 0);
        resultMap.put(WinningTable.FOUR.matchNumber, 0);
        resultMap.put(WinningTable.FIVE.matchNumber, 0);
        resultMap.put(WinningTable.SIX.matchNumber, 0);
    }

    @ParameterizedTest
    @CsvSource(value = {"3:1", "4:1", "5:1", "6:1", "3:5"}, delimiter = ':')
    void 당첨금_계산(int matchNumber, int matchCount) {
        resultMap.put(matchNumber, matchCount);

        YieldCalculator yieldCalculator = new YieldCalculator();
        yieldCalculator.proceedsCalculate(resultMap);

        assertThat(yieldCalculator.proceedsTotal())
                .isEqualTo(WinningTable.of(matchNumber)
                        .multiply(matchCount));
    }
}
