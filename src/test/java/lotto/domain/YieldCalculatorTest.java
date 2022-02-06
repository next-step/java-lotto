package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class YieldCalculatorTest {

    Map<LottoResult, Integer> lottoResults;

    @BeforeEach
    void setUp() {
        lottoResults = new HashMap<>();
        lottoResults.put(LottoResult.MATCH3, 5);
        lottoResults.put(LottoResult.MATCH4, 4);
        lottoResults.put(LottoResult.MATCH5, 1);

    }

    @Test
    void 수익률_계산하기() {
        assertThat(YieldCalculator.calculateYield(lottoResults, 1000)).isEqualTo(375.00);
    }
}