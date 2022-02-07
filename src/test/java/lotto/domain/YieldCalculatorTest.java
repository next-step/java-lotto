package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.EnumMap;
import java.util.Map;
import lotto.domain.money.Money;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class YieldCalculatorTest {

    Map<LottoResult, Integer> lottoResults;

    @BeforeEach
    void setUp() {
        lottoResults = new EnumMap<>(LottoResult.class);
        lottoResults.put(LottoResult.MATCH3, 5);
        lottoResults.put(LottoResult.MATCH4, 4);
        lottoResults.put(LottoResult.MATCH5, 1);
    }

    @Test
    void 수익률_계산하기() {
        assertThat(YieldCalculator.calculateYield(lottoResults, new Money(1000))).isEqualTo(375.00);
    }
}