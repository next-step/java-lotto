package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class YieldCalculatorTest {

    List<LottoResult> lottoResults;

    @BeforeEach
    void setUp() {
        lottoResults = new ArrayList<>();

        LottoResult.increaseMatch(3, false);
        LottoResult.increaseMatch(3, false);
        LottoResult.increaseMatch(4, false);
        LottoResult.increaseMatch(4, false);
        LottoResult.increaseMatch(4, false);
        LottoResult.increaseMatch(5, false);
        lottoResults = Arrays.stream(LottoResult.values()).collect(Collectors.toList());
    }

    @Test
    void 수익률_계산하기() {
        assertThat(YieldCalculator.calculateYield(lottoResults, 1000)).isEqualTo(310.00);
    }
}