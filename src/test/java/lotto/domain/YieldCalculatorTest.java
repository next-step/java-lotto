package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.EnumMap;
import java.util.Map;
import lotto.domain.money.Money;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class YieldCalculatorTest {

    MatchResult lottoResults;

    @BeforeEach
    void setUp() {
        final Map<LottoResult, Integer> results = new EnumMap<>(LottoResult.class);
        results.put(LottoResult.MATCH3, 5);
        results.put(LottoResult.MATCH4, 4);
        results.put(LottoResult.MATCH5, 1);
        lottoResults = new MatchResult(results);
    }

    @Test
    void 수익률_계산하기() {
        assertThat(YieldCalculator.calculateYield(lottoResults, new Money(1000))).isEqualTo(375.00);
    }
}
