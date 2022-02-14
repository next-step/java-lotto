package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class YieldCalculatorTest {

    LottoResult lottoResult;
    LottoCount lottoCount;

    @BeforeEach
    void setUp() {
        lottoResult = new LottoResult();
        lottoResult.upCount(LottoDescription.findLottoHash(3, false));
        lottoResult.upCount(LottoDescription.findLottoHash(3, false));
        lottoResult.upCount(LottoDescription.findLottoHash(4, false));
        lottoResult.upCount(LottoDescription.findLottoHash(4, false));
        lottoResult.upCount(LottoDescription.findLottoHash(4, false));
        lottoResult.upCount(LottoDescription.findLottoHash(5, false));
        lottoCount = new LottoCount(1000);
    }

    @Test
    void 수익률_계산하기() {
        assertThat(YieldCalculator.calculateYield(lottoResult, lottoCount)).isEqualTo(310.00);
    }
}
