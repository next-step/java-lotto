package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.LinkedHashMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class YieldCalculatorTest {
    private LinkedHashMap<String, Integer> resultMap = new LinkedHashMap<>();

    @BeforeEach
    void setUp() {
        resultMap.put(WinningTable.FIFTH.name(), 0);
        resultMap.put(WinningTable.FOURTH.name(), 0);
        resultMap.put(WinningTable.THIRD.name(), 0);
        resultMap.put(WinningTable.SECOND.name(), 0);
        resultMap.put(WinningTable.FIRST.name(), 0);
    }

    @ParameterizedTest
    @CsvSource(value = {"'FIFTH':5", "'FOURTH':4", "'THIRD':3", "'SECOND':2", "'FIRST':1"}, delimiter = ':')
    void 당첨금_계산(String matchString, int matchCount) {
        resultMap.put(matchString, matchCount);

        YieldCalculator yieldCalculator = new YieldCalculator();
        yieldCalculator.proceedsCalculate(resultMap);

        assertThat(yieldCalculator.proceedsTotal())
                .isEqualTo(WinningTable.valueOf(matchString)
                        .multiply(matchCount));
    }
}
